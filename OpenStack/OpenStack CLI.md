# OpenStack CLI로 관리  - 수동 설치 

## 1. identity 서비스 (Keystone)

> 사용자 관리와 서비스 카탈로그(자신의 API 엔드포인트로 사용가능 한 서비스의 카탈로그 제공)
>
> 여럿 메타정보들은 마리아디비로 관리한다.

- cretentials :  누군지를 증명하기 위한 사용자 데이터 (아이디 , 비번)
- 인증 :  id, pw ,API 사용자의 신원을 확인하는 행위 
- 사용자 : 사용자가 로그인을하고 자원에 접근할 수 있는 토큰 할당 / 특정 프로젝트의 멤버 
- 토큰 : 임의의 텍스트 bit 
- Tenant : =프로젝트,  사용자 그룹
- 서비스 :   compute(nova), image(glance)같은 오픈 스택 서비스 
- 에드포인트 : 서비스로 접근하려고 하는 , 보통  url 
- 역활 : 사용자가 특별한 작업을 수행할 수 있도록 책임을 맡은 고유한 성격

    ```
    # source keystonerc_admin     // . keystonerc_admin
    # openstack user list        //cLI 명령을 가지고 작업 가능 
    # openstack role list --user stack1 --project pro1  // 부여받은 role 확인 가능 
    ```

- CLI로 프로젝트/ 사용자 / 역활 

  ```
  # openstackproject create --description "Demo Project" demo  //프로젝트 생성
  # openstackuser create --password abc123 –project demo demo // 사용자 생성
  # openstackrole add --project demo --user demo _member_  // 멤버 권한 부여 
  # openstackrole list --project demo --user demo //list 확인
  # openstack token issue // 토큰 발급
  
  # cp keystonerc_admin keystonerc_stack1
  # vi kestonerc_stack1  // userid, projectname 바꾸기 
  # .keystonerc_stack1   // 데시보드에서 stack1으로 로그인 하는 것과 동일 
  ```

## 2. 환경 설정 - 수동 설치를 위한 [설치가이드](https://docs.openstack.org/install-guide/environment.html)

- vm - manual-controller 만들기 (파일 controller2에 기본 vm 이미지 복붙 )

- ```
  # yum repolist  // package를 모아놓은 저장소인 repolist에 패키지 다운로드
  # yum update -y 
  # reboot
  # vi /etc/sysconfig/network-scripts/ifcfg-ens33 -> 주석지우고 ipadress변경(10.0.0.11) 
  # systemctl restart network   //네트워크 설정 
  ```

- NTP(nerwork time protocol)

  ```
  # hostnamectl set-hostname controller2
  # hostnamectl set-hostname controller  //hostname 수정 
  # hostnamectl status // 적용 확인 
  # cat /etc/hostname  //설정파일 적용된지 확인 
  # vi /etc/chrony.conf
  # chronyc sources            // 이미 chrony 설치됨 
  # rpm -qa |grep openstack
  # yum repolist  
  # yum upgrade -y
  # yum install python-openstackclient
  # yum install openstack-selinux -y 
  ```

- SQL database for RHEL and CentOS

  ```
  # yum install mariadb mariadb-server python2-PyMySQL
  # cd /etc/my.cnf.d
  # vi openstack.cnf    // 파일 수정하기 
  # systemctl enable mariadb.service
  # systemctl start mariadb.service
  # systemctl status mariadb.service
  # mysql_secure_installation
  # mysql -uroot -p
  ```

-  Message queue for RHEL and CentOS

  ```
  # yum install rabbitmq-server -y
  # systemctl enable rabbitmq-server.service
  # systemctl start  rabbitmq-server.service
  # rabbitmqctl add_user openstack RABBIT_PASS
  # rabbitmqctl set_permissions openstack ".*" ".*" ".*"
  ```

-  Memcached for RHEL and CentOS

  ```
  # yum install memcached python-memcached
  # vi /etc/sysconfig/memcached
  # systemctl enable memcached.service
  # systemctl start  memcached.service
  # systemctl status  memcached.service		
  ```

- 네트워크 연결을 보여주는 명령 (netstat) - ss 로 대체 가능 

- ```
  # netstat -an|grep 11211
  # ss -nlp|grep 11211 //n: 호스트,포트,사용자이름을 숫자로 표시 l:listen상태 포트 확인 , 
  p : 프로세스명을 표시  
  ```

## 3. Keystone 설치 -수동 설치를 위한  [참고](https://docs.openstack.org/keystone/rocky/install/keystone-install-rdo.html)

- MariaDB 

  ```mysql
  # mysql -u root -p 
  MariaDB [(none)]> CREATE DATABASE keystone;
  MariaDB [(none)]> GRANT ALL PRIVILEGES ON keystone.* TO 'keystone'@'localhost' \
  IDENTIFIED BY 'KEYSTONE_DBPASS';
  MariaDB [(none)]> GRANT ALL PRIVILEGES ON keystone.* TO 'keystone'@'%' \
  IDENTIFIED BY 'KEYSTONE_DBPASS';
  ```

- http Server 

  ```
  # yum install openstack-keystone httpd mod_wsgi -y
  # vi /etc/keystone/keystone.conf   // 수정하기 
    742 connection = mysql+pymysql://keystone:KEYSTONE_DBPASS@controller/keystone
    2829 provider = fernet
  # su -s /bin/sh -c "keystone-manage db_sync" keystone
  # cd /var/lib/mysql
  # ls keystone/
  # keystone-manage fernet_setup --keystone-user keystone --keystone-group keystone
  # keystone-manage credential_setup --keystone-user keystone --keystone-group keystone
  # keystone-manage bootstrap --bootstrap-password ADMIN_PASS   --bootstrap-admin-url http://controller:5000/v3/   --bootstrap-internal-url http://controller:5000/v3/   --bootstrap-public-url http://controller:5000/v3/   --bootstrap-region-id RegionOne
  #  vi  /etc/httpd/conf/httpd.conf  //  ServerName controller 수정하기 
  # ln -s /usr/share/keystone/wsgi-keystone.conf /etc/httpd/conf.d/
  # systemctl enable httpd.service
  # systemctl start httpd.service
  # ss -nlp|grep http
    // tcp    LISTEN     0      128    [::]:5000               [::]:* 
  # export OS_USERNAME=admin
  # export OS_PASSWORD=ADMIN_PASS
  # export OS_PROJECT_NAME=admin
  # export OS_USER_DOMAIN_NAME=Default
  # export OS_PROJECT_DOMAIN_NAME=Default
  # export OS_AUTH_URL=http://controller:5000/v3
  # export OS_IDENTITY_API_VERSION=3                // admin pw : ADMIN_PASS
  ```

- domain, project, user,role  생성 

  ```
  # openstack domain create --description "An Example Domain" example  //도메인 생성
  # openstack project create --domain default   --description "Service Project" service  // default 프로젝트 생성
  # openstack project create --domain default   --description "Demo Project" myproject // myproject 생성
  # openstack user create --domain default   --password-prompt myuser  //사용자 생성
  # openstack role create myrole // role 생성 
  # openstack role add --project myproject --user myuser myrole  //사용자한테 룰 지정
  ```

- ```
  # unset OS_AUTH_URL OS_PASSWORD //자동으로 설정된 url과 pw unset 하기 
  # openstack --os-auth-url http://controller:5000/v3 \
    --os-project-domain-name Default --os-user-domain-name Default \ 
    --os-project-name admin --os-username admin token issue     //admin
  # openstack --os-auth-url http://controller:5000/v3 \
    --os-project-domain-name Default --os-user-domain-name Default \
    --os-project-name myproject --os-username myuser token issue  //myuser
  ```

- script 만들고 로그인 하기  

  ```
  # vi /admin-openrc 
  # vi /demo-openrc
  
  # . admin-openrc
  # openstack token issue
  
  ```



## 4. Glance - image service (5장) [참조](https://docs.openstack.org/glance/rocky/install/install-rdo.html)

> 사용자가 가상머신 이미지를 발견, 등록 및 검색 할 수 있게 해줌
>
> 가상머신 이미지의 메타데이터를 query 하고 실제 이미지를 검색 할 수 있는 REST API를 제공 
>
> nova가 사용함 

- 이미지 파일 설치 및 확인 명령어 

  ```shell
  $ yum install -y wget // 주소를 통해 다운로드 명령어 wget 
  $ wget https://download.cirros-cloud.net/0.3.5/cirros-0.3.5-x86_64-disk.img //이미지 다운로드 
  $ file cirros-0.3.5-x86_64-disk.img   //이미지 파일 확인
  $ qemu-img info cirros-0.3.5-x86_64-disk.img // 자세하게 
  $ qemu-img convert -O vmdk cirros-0.3.5-x86_64-disk.img cirros-0.3.5-x86_64-disk.vmdk
    // img파일을 vmdk 파일로 하나더 생성 
  $ file cirros-0.3.5-x86_64-disk.vmdk
  $ qemu-img info cirros-0.3.5-x86_64-disk.vmdk //vmdk파일 확인 
  $ cp cirros-0.3.5-x86_64-disk.vmdk /mnt/hgfs/share_linux 
  해당 vmdk로 vm에서 cirros vm 만들어서 잘 되는지 확인하기 
  ```

- glance 이미지 확인 / 생성

  ```shell
  $ . keystonerc_stack1
  $ glance image-list   // 이미지 확인 
  
  $ openstack 
  	# image list      // 이미지 확인     -- /var/lib/glance/images
  $ openstack image create "cirros-vmdk" --file /root/cirros-0.3.5-x86_64-disk.vmdk --disk-format vmdk --container-format bare  //이미지 생성(이미지등록) --public(admin계정만 가능)
  $ glance image-show 1ac0d79b-f5e7-4341-8208-09a79115941c // 이미지 id로 자세하게 확인가능 
  ```

- 수동 설치 - manual

  ```shell
  $ mysql -u root -p
  # MariaDB [(none)]> CREATE DATABASE glance;
  # MariaDB [(none)]> GRANT ALL PRIVILEGES ON glance.* TO 'glance'@'localhost' \
    IDENTIFIED BY 'GLANCE_DBPASS';
  # MariaDB [(none)]> GRANT ALL PRIVILEGES ON glance.* TO 'glance'@'%' \
    IDENTIFIED BY 'GLANCE_DBPASS';
  $ . admin-openrc
  $ openstack user create --domain default --password-prompt glance
  $ openstack user set --domain default --password GLANCE_PASS glance
  $ openstack role add --project service --user glance admin
  $ openstack service create --name glance \
    --description "OpenStack Image" image
  $ openstack endpoint create --region RegionOne \
    image public http://controller:9292
  $ openstack endpoint create --region RegionOne \
    image internal http://controller:9292
  $ openstack endpoint create --region RegionOne \
    image admin http://controller:9292
  $ yum install openstack-glance
  $ vi /etc/glance/glance-api.conf            // 파일 수정 
  $ vi /etc/glance/glance-registry.conf      // 파일 수정
  $ su -s /bin/sh -c "glance-manage db_sync" glance
  $ systemctl enable openstack-glance-api.service \
    openstack-glance-registry.service
  $ systemctl start openstack-glance-api.service \
    openstack-glance-registry.service
    
  글라스 이미지 다운로드 (controller에서 했던거 manual-controller에서 )
  $ . admin-openrc 
  $  yum install -y wget
  $  wget https://download.cirros-cloud.net/0.3.5/cirros-0.3.5-x86_64-disk.img
  $  openstack image create "cirros" --file cirros-0.3.5-x86_64-disk.img --disk-format qcow2 --container-format bare --public
  $ openstack image list
  ```

  ## 5. NOVA - compute service

  > copute node 확장 가능 
  >
  > nova -scheduler(nova db에서) 
  >
  > Devops(k&s)-docker 플랫폼 

- manual-controller(node) 에  nova 설치  [참조](https://docs.openstack.org/nova/rocky/install/)

  > 참고 처럼 한 후에 

  ```shell
  $ openstack compute service list   // 
  ```

  ![캡처22](https://user-images.githubusercontent.com/35915879/71713834-afcd1000-2e4e-11ea-841b-6e5f0f9eeaee.PNG)

- compute1 vm 설치 / compute1 node 설치  [참고](https://docs.openstack.org/nova/rocky/install/compute-install-rdo.html)

  - hostname 변경 및 ip 수정 

  ```shell
  $ hostnamectl set-hostname compute1
  $ exit 
  $ vi /etc/sysconfig/network-scripts/ifcfg-ens33
  	#UUID
  	IPADDR=10.0.0.101
  $ systemcrl restart network 
  ```

  - compute1에 설치

	```shell
    $ yum install openstack-nova-compute
    $ cd /etc/nova/
    $ cp nova.conf nova.conf.old
    $ scp controller:/etc/nova/nova.conf /etc/nova/nova.conf
    $ ls -l /etc/nova/nova.conf
    $ vi /etc/nova/nova.conf
    my_ip=10.0.0.101
    vncserver_proxyclient_address = 10.0.0.101
    $ systemctl enable libvirtd.service openstack-nova-compute.service
    $ systemctl start libvirtd.service
    $ systemctl start openstack-nova-compute.service // controller의 방화벽 풀어줘야함 
  ```
  
  - controller에 방확벽 풀어줘야함 
  
  ```shell
  $ vi /etc/sysconfig/iptables
  13번 아래에 추가
  -A INPUT -s 10.0.0.101/32 -p tcp -m multiport --dports 5671,5672 -m comment --comment "001 amqp incoming amqp_10.0.0.101" -j ACCEPT
  -A INPUT -s 10.0.0.101/32 -p tcp -m multiport --dports 5671,5672 -j ACCEPT
  -A INPUT -s 10.0.0.100/32 -p tcp -m multiport --dports 5671,5672 -j ACCEPT
  
  $ systemctl reload iptables
  ```
  
  

## 6. Neutron  - network service 

> 네트워크 방화벽 서비스 , 로드밸런스 서비스 , 
>
> 클라우드 사용자마다 내부 네트워크 생성가능 , 라우터 (외부 네트워크랑 연결하기 위한), 서브넷 -> 객체의 추상화 
>
> - open vSwitch plug-in - neutron이 지원하는 프로그인 종류(현재 쓰고 있는 플러그인) 
>
> ​        들어올떄 (DNAT, Dip-> 사설 ip) -----나갈때 (SNATm Sip -->공인 ip) 
	>
    > ```shell
    > $ip netns exec qrouter-a1b0c327-247a-4bb3-912d-08e3e9947408 iptebles -t nat -L 
    > //SNAt , DNAT 정보를 확인 
    > ```
>
> - 분리 구조 (ML2은 compute 노드마다 다르게 사용 할 수 있다)
>  - 컨트롤러 노드 - server, plugin agent, L2-openswitch
>   - 네트워크 노드 -  plugin, L3, DHCP, Layer 2 agent(라우터 역활)
>   - 컴퓨트 노드 - plugin , L2-리눅스 브릿지-agent   -- 요즘은 물러적인 네트워크가 아닌 외부에서 바로 노드에 접속하는 것을 선호

- ML2

  - Local - host only bridge (동일한 컴퓨트 호스트 안에 같은 네트워크 통신만 가능)

  - Flat - 별도의 플렛 망 구성시 별도의 물리적인 인터페이스간의 연결, 네트워크 주소가 다른경우에는 라우터를 통해서 연결이 가능하다

  - VLAN - 같은 vlanid라는 것을 적용해서 트래픽 분리 , 물리적인 스위치와도 연결이 가능 mac(2계층)주소 가짐 

  - GRE/VxLAV - VLAN의 확장 버전 클라우드에 적합함 -id 개수 4000개 이상 필요할 경우 

    ```shell
    $ ovs-vsctl show // 가상의 네트워크 출력 
    ```

  - 메커니즘 드라이버 

- 인스턴스에 대한 연결을 제공한느 네트워트 종류

  - provider networks - 관리자가 생성
  - self-service networks  - 사용자가 생성 

- 확인

  ```shell
  $ . keystonerc_admin  
  $ neutron agent-list // 설치된 agent 리스트 출력 
  $ openstack-service status neutron  // neutron 상태 출력 (openstack-status 모든 패키지 출력)
  $ neutron ext-list // 확장자 리스트 확인
  $ grep NEUTRON openstack.txt
  $ ip netns // 라우터 리스트 출력 
  $ ip netns exec 라우터id ip a //
```
  
- 설치 [참고](https://docs.openstack.org/neutron/rocky/install/)

  ```shell
  $ yum install openstack-neutron-linuxbridge ebtables ipset
  $ cp /etc/neutron/neutron.conf /etc/neutron/neutron.conf.old
  $ scp controller:/etc/neutron/neutron.conf /etc/neutron/neutron.conf
  $ chgrp neutron /etc/neutron/neutron.conf
  
  **Networking Option 2: Self-service networks**
  
  $ vi /etc/neutron/plugins/ml2/linuxbridge_agent.ini
  $ lsmod|grep br_netfilter
  $ modprobe br_netfilter
  $ sysctl -a |grep bridge-nf
  net.bridge.bridge-nf-call-ip6tables = 1
  net.bridge.bridge-nf-call-iptables = 1  //확인 
  $ systemctl enable neutron-linuxbridge-agent.service
  $ systemctl start neutron-linuxbridge-agent.service
  
  controller 에서 
  $ openstack network agent list //확인 (compute - Linux bridge agent)
  ```

## 7. CLI로 Instance 시작 -controller 

- 가상 네트워크 인프라 구축 [참고](https://docs.openstack.org/install-guide/launch-instance-networks-selfservice.html)

  ```shell
  $ . keystonerc_demo
  $ openstack network create selfservice
  $ openstack subnet create --network selfservice   --dns-nameserver 8.8.4.4 --gateway 172.16.1.1   --subnet-range 172.16.1.0/24 selfservice
  $ openstack router create router
  $ openstack router add subnet router selfservice
  $ openstack router set router --external-gateway ext1
  $ . keystonerc_admin 
  $ openstack port list --router route
  ```

- 리소스 구축 [참고](https://docs.openstack.org/install-guide/launch-instance.html)

  ```shell
  $ openstack flavor create --id 0 --vcpus 1 --ram 64 --disk 1 m1.nano
  $ openstack flavor list
  $ . keystonerc_demo 
  $ ls .ssh
  $ openstack keypair create --public-key ~/.ssh/id_rsa.pub mykey
  $ openstack keypair list
  $ openstack security group rule create --proto icmp default
  $ openstack security group rule create --proto tcp --dst-port 22 default
  $ openstack image list
  $ openstack image create "cirros-0.3.5" --container-format bare --disk-format qcow2 --file ./cirros-0.3.5-x86_64-disk.img 
  $ openstack image list
  ```

- 인스턴스  생성 [참조](https://docs.openstack.org/install-guide/launch-instance-selfservice.html)

  ```shell
  $ . demo-openrc
  $ openstack network list 
  $  openstack server create --flavor m1.nano --image cirros-0.3,5 \
    --nic net-id=59f7d72b-0042-418f-8e38-56f04aaaa9ed --security-group default \
    --key-name mykey selfservice-instance
  $  openstack server list
  $ openstack console url show selfservice-instance //콘솔 접속 url
  $  virsh list --all
  $  virsh console 1  //콘솔 1으로 접속 
  
  $ openstack floating ip create ext1
  $ openstack server add floating ip selfservice-instance 10.0.0.217
  $ ip netns exec qrouter-96c47acc-753f-4669-a93f-490b309abce4 ssh cirros@10.0.0.217
  ```

## 8. Block Storage (Cinder)

> 기본 벡압 스토리지 는 LVM이다.  
>
> 가장 많이 사용하는 백업 스토리지 는  Ceph 스토리지이다. 
>
> - 스냅샷 백업 - LVM의 스냅샵 공간 사용 
> - cinder 백업 - swift와 연동 		



- 스토리지 
  - block 스토리지 - cinder , EBS
  - file 스토리지  - NFS, EFS
  - object 기반 스토리지 - swift, S3
  - db 기반 스토리지 - mysql, Trove  

- iSCSI - 컴퓨팅 환경에서 데이터스토리지 시설을 이어주는 IP기반의 스토리지 네트워킹 표준이다.

- cinder 만들기 

  ```shell
  $ cinder create --name demo-v1 1
  $ cinder list 
  $ lvs 
  $ vgs
  $ pvs 
  $ nova volume-attach selfservice-instance a4a545cc-1ecf-4bc9-9d40-ab5124bd87ef auto
  $ lsblk
  ```

​	

## 9. object Storage(Swift) 

```shell
$ swift post demo-c1  //생성
$ swift upload demo-c1 cirros-0.3.5-x86_64-disk.img // 업로드 
$ swift list demo-c1 --lh  //확인
$ cd /var/tmp 
$ swift download demo-c1   // 다운로드
```

