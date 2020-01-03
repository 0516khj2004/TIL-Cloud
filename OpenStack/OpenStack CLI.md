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
  
  