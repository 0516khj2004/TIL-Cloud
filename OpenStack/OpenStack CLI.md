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
  # yum repolist 
  # yum update -y 
  # reboot
  # vi /etc/sysconfig/network-scripts/ifcfg-ens33 -> 주석지우고 ipadress변경(10.0.0.11) 
  # systemctl restart network   //네트워크 설정 
  ```

- ```
  # hostnamectl set-hostname controller2
  # hostnamectl set-hostname controller
  # vi /etc/chrony.conf
  # chronyc sources
  # rpm -qa |grep openstack
  # yum repolist  
  # yum upgrade -y
  # yum install python-openstackclient
  # yum install openstack-selinux -y 
  
  SQL database for RHEL and CentOS
  
  # yum install mariadb mariadb-server python2-PyMySQL
  # cd /etc/my.cnf.d
  # vi openstack.cnf
  [mysqld]
  bind-address = 10.0.0.11
  
  default-storage-engine = innodb
  innodb_file_per_table = on
  max_connections = 4096
  collation-server = utf8_general_ci
  character-set-server = utf8
  
  # systemctl enable mariadb.service
  # systemctl start mariadb.service
  # systemctl status mariadb.service
  # mysql_secure_installation
  # mysql -uroot -p
     
   Message queue for RHEL and CentOS
  # yum install rabbitmq-server -y
  # systemctl enable rabbitmq-server.service
  # systemctl start  rabbitmq-server.service
  # rabbitmqctl add_user openstack RABBIT_PASS
  # rabbitmqctl set_permissions openstack ".*" ".*" ".*"
   
   Memcached for RHEL and CentOS
  # yum install memcached python-memcached
  # vi /etc/sysconfig/memcached
  # systemctl enable memcached.service
  # systemctl start  memcached.service
  # systemctl status  memcached.service
  # netstat -an|grep 11211
  # ss -nlp|grep 11211
  
  Install and configure
  # mysql -u root -p 
     
  # yum install openstack-keystone httpd mod_wsgi -y
     67  vi /etc/keystone/keystone.conf
     68   su -s /bin/sh -c "keystone-manage db_sync" keystone
     69  cd /var/lib/mysql
     70  ls
     71  ls keystone/
     72  keystone-manage fernet_setup --keystone-user keystone --keystone-group keystone
     73  keystone-manage credential_setup --keystone-user keystone --keystone-group keystone
     74  keystone-manage bootstrap --bootstrap-password ADMIN_PASS   --bootstrap-admin-url http://controller:5000/v3/   --bootstrap-internal-url http://controller:5000/v3/   --bootstrap-public-url http://controller:5000/v3/   --bootstrap-region-id RegionOne
     75  ServerName controller
     76  vi  /etc/httpd/conf/httpd.conf 
     77  ln -s /usr/share/keystone/wsgi-keystone.conf /etc/httpd/conf.d/
     78  systemctl enable httpd.service
     79   systemctl start httpd.service
     80  ss -nlp|grep http
     81  export OS_USERNAME=admin
     82  export OS_PASSWORD=ADMIN_PASS
     83  export OS_PROJECT_NAME=admin
     84  export OS_USER_DOMAIN_NAME=Default
     85  export OS_PROJECT_DOMAIN_NAME=Default
     86  export OS_AUTH_URL=http://controller:5000/v3
     87  export OS_IDENTITY_API_VERSION=3
     88  openstack domain create --description "An Example Domain" example
     89  openstack project create --domain default   --description "Service Project" service
     90  openstack project create --domain default   --description "Demo Project" myproject
     91  openstack user create --domain default   --password-prompt myuser
     92  openstack role create myrole
     93  openstack role add --project myproject --user myuser myrole
     94  unset OS_AUTH_URL OS_PASSWORD
     95  openstack --os-auth-url http://controller:5000/v3   --os-project-domain-name Default --os-user-domain-name Default   --os-project-name admin --os-username admin token issue
     96  openstack --os-auth-url http://controller:5000/v3   --os-project-domain-name Default --os-user-domain-name Default   --os-project-name admin --os-username admin token issue
     97  openstack --os-auth-url http://controller:5000/v3   --os-project-domain-name Default --os-user-domain-name Default   --os-project-name myproject --os-username myuser token issue
     98  openstack --os-auth-url http://controller:5000/v3   --os-project-domain-name Default --os-user-domain-name Default   --os-project-name myproject --os-username myuser token issue
     99  vi admin-openrc
    100  vi demo-openrc
    101  mv *openrc /root
    102  cd
    103  ls
    104  . admin-openrc
    105  openstack token issue
    106  hostnamectl set-hostname controller2
    107  history 
  
  ```

- 

