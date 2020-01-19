# openstack 실습 

> controller 10.0.0.200 (6G,2cpu)
>
> compute1 10.0.0.201 (2G, 2cpu)

## controller compute 설정

1. vm구축 

2. ip 변경

   ```
   $ vi /etc/sysconfig/network-scripts/ifcfg-ens33
   $ systemctl restart network 
   ```

3. hostname 변경  

   ```
   $ hostname set-hostname compute1
   $ reboot
   ```

4. hosts 설정 

   ```
   $ vi /etc/hosts
   # 10.0.0.200 controller 
   # 10.0.0.201 comput1
   $reboot
   ```

## controller 설정 

1. openstack- packstack 설치 과정 

    ```
    $ yum update         // yum을 최신으로 업데이트 한다.
    $ yum install -y centos-release-openstack-rocky  
    $ yum repolist      //네트워크 확인
    $ yum upgrade -y    //커널을 포함한 업그레이드
    $ yum install -y opentack-packstack*
    $ rpm -qa|grep openstack    // openstack package 정보 확인
    ```

2. packstack 사용하기

   ```
   $ cp /root/openstack.txt /root/openstack.orig
   $ vi /root/openstack.txt
   
   #CONFIG_DEFAULT_PASSWORD=abc123 
   #CONFIG_CEILOMETER_INSTALL=n 
   #CONFIG_AODH_INSTALL=n 
   #CONFIG_KEYSTONE_ADMIN_PW=abc123 
   #CONFIG_HEAT_INSTALL=y 
   #CONFIG_MAGNUM_INSTALL=y 
   #CONFIG_TROVE_INSTALL=y 
   #CONFIG_NEUTRON_L2_AGENT=openvswitch 
   #CONFIG_NEUTRON_OVS_BRIDGE_IFACES=br-ex:ens33
   #CINFIG_COMPUTE_HOSTS=10.0.0.200,10.0.0.201
   
   $ packstack --gen-answer-file=/root/openstack.txt //다운
   ```

   

## glance의 backend stores를 swift와 연결

1. glance-api.conf 수정 

   ```
   $ . keystonerc_admin  //접속 
   $ openstack image list
   $ vi /var/lib/glance/images
   # default_store=swift
   # #filesystem_store_datadir=/var/lib/glance/images/ //주석처리
   # swift_store_auth_version = 3 // 주석 삭제
   # swift_store_auth_address =  http://10.0.0.200:5000/v3
   // cat keystonerc_admin에서 주소 확인
   # swift_Store_user = services
   # swift_store_key = 546994f1a64c470e 
   // grep SWIFT answerfile.txt에서 ks_pw 확인
   # swift_store_create_container_on_put = True
   # swift_store)container = glance
   # os_region_name=RegionOne
   // cat keystonerc_admin에서 region_name확인
   ```

2. dashbord에 연결하여 cirros 이미지 등록

   ```
   $systemcrl restart openstack-glance-api openstack-glace-registry
   ```

3. admin / swift  dashbord에서 확인하기 

