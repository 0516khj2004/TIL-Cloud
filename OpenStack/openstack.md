## 1. Cloud Computing (1장)

> **사용자의 요청**에 따라 공유된 컴퓨터의 자원이나 데이터를 사용자가 이용하는 컴퓨터 , 휴대폰과 같은 다른 장치로 제공하는 **인터넷 기반**의 컴퓨팅 환경 

- on-premise : 시스템 자체를 모두 구매하여 서비스 구축하는 것
- Iaas : it 관계자 (infrastructure) --aws
- Paas : 개발자 (platform) -- cloudformation
- Saas : end 사용자(기업, 일반)  (application/ software)

## 2. OpenStack 

> **클라우드 컴퓨팅**의 laas로서 클라우드 컴퓨팅 환경에서 사용되는 무료 오픈소스 클라우드 소프트웨어 
>
> ``nasa`` - nova `` rackspace`` - swift 하던 프로젝트를 오픈소스화 함 
>
> ``public`` (any) , ``private``(권한이 있는 자 ) 클라우드를 구축하는 오픈소스 
>
> - 2006 :  aws(인터넷 os)
> - 2008 : cloudstack 
> - 2010: openstack (cloud os)

- 오픈 스택 구성도 

![캡처](https://user-images.githubusercontent.com/35915879/71605290-0f0af600-2bab-11ea-8048-c44503c6083c.PNG)

  
- storage 유형 

  -  **object** (file + meta )  -- swift / s3 <- RESTFUL API 
  -  **block**  -- cinder /EBS <- 장치file 할당 받음 /dev/sd(a,b,c,,,) 
  -  **file**  --  Manila/ NFS / EFS <- 자동 mount 
  -  **database** 

- 각 릴리즈 Note 

  - Rocky사용 https://docs.openstack.org/rocky/index.html 참조 

- OpenStack Conceptual Diagram

![캡처](https://user-images.githubusercontent.com/35915879/71605383-d1f33380-2bab-11ea-9513-4f106280d4cf.PNG)


- 오픈스택 서비스 종류 

  - Keynote  **( identity service)**
    - keynote  인증을 통해서 토큰을  생성 
    - 생성된 토큰을 keystone에 저장 
    - 토큰id 반송 
    - 토큰 id 를 가지고 요청을 보냄 
    - 토큰 id 를 확인하고 클라이언트의 역활을 점검 
  - Glance **(image)**
    - 가상 디스크 이미지들을 저장/등록/관리/전달 할 수 있게 하느 오픈소스 
  - Neutron **(network)**
    - 소프트웨어 기반의 네트워킹 서비스 제공 
  - Nova **(cloude compute)**
    - 가상머신 라이프사이클 관리자 
    - ``KVM``(커널-os에서 핵심 프로그램 로 구현 성능 개선) , ``Qemu``(성능 느림) 하이퍼 바이저
    - 필요에 의해서 유료의 하아퍼 바이저를 받을 수 있다
    - 컨테이너 기반의 docker 인스턴스(vm)를 사용 할 수 있다.
  - Cinder **(block storage)**
    - 생성된 가상 디스크 볼륨은 가상머신에 **마운트** 되어 가상머신 사용자의 데이트를 저장하는데 사용
    - block storage - vm이 디스크 스토리지가 부족해서 쓰는 서비스 
  - Swift **(cloud storage)**
    - object storage - end user 가 쓰는 서비스 
    - 대용량 데이터를 저장할 수 있는 높은 확장성을 가진 오브젝트 저장장치를 제공하는 서비스 
  - Horizon**(dashbord service)**
    - 아파치 웹 서버를 사용하며, 데쉬보드는 파이썬 장고 프레임워으로 구현되어 있다.



- 가상화 [가상화 정리 요점 ](https://tech.cloud.nongshim.co.kr/2018/09/18/가상화의-종류3가지/)

  - hyperviser

    > Host OS없이 하드웨어에 하이퍼바이저를 설치하여 사용하는 방식입니다. 종류로는 Xen, MS hyper-V, citrix, KVM 등이 있습니다.

    - FUll virtualization(전가상화) -- 오버헤드증가 ,성능 저하 
      - s/w , h/w (cpu *필수조건*,memory에 가상모드을 켜줌 )
    - Para vritualization (반가상화)  -- 성능은 pull보다 좋다 

  - container 

    >호스트 OS위에 컨테이너관리 소프트웨어를 설치하여, 논리적으로 컨테이너를 나누어 사용합니다.
    >컨테이너는 어플리케이션 동작을 위한 라이브러리와 어플리케이션등으로 구성되기때문에 이를 각각 개별 서버처럼 사용가능합니다.

## 3. 오픈스택 설치 방법

- manual 설치  

  > 서버가 재부팅되어도 서비스 계속할 수 있음 -자동 enable가능 (우분투경우)
  >
  > 자신이 원하는 데로 설치가 가능 	

- 자동화 툴 이용한 설치 

  > ensible , salt ,chef, puppet ..등 도구를 의해서 자동으로 설치 	
  >  scale up : 박스내에서 cpu 상승시킴
  >  scale out  : 박스 밖에서 박스 단위로   [정리문서](https://m.blog.naver.com/islove8587/220548900044)
  - RedhatSolutions
    - ***Packstack***     // puppet (devstack 보다 빠르다) 
    - Foreman / OpenstackPlatform Director     //그래픽 
  - Canonical Solutions
    - Juju/Maas/Charms
  - MirantisSolutions
    - Fuel    
  - Ubuntu
    - Devstack     // shell script(속도가 느리다)
    - Openstackinstaller
  - openstack-ansible(lxc+ansible) -OSA  //우분투설치방법 
  - Kolla(docker+ansible)  //docker 이미지를 가지고 바로 배포하는 방법 
  - openstack-helm(openstackon k8s) 
  
- Devstack 을 통해서 설치 

  > 서버가 재부칭 되는 경우 서비스를 할 수 없는 단점
  >
  > 데스트 목적로 사용하는 것을 권장

## 4. Packstack을 통한 OpenStack 환경 구축-선행 (2장-3장)

> - all-in-node -- controller node
> - two node -- controller node + compute node(인스턴스, vm , 하이퍼 바이저) 
> - three node -- controller node + copute node + network node (네트워크 오버헤드가 크기때문에)
> - four node -- controller node + copute node + network node + storage node 

![캡처1](https://user-images.githubusercontent.com/35915879/71605394-e800f400-2bab-11ea-983d-4e2d70a322f7.PNG)


- all-in-node

  - cores 2, memory 6200 , disk 100 single file 
  - 최소설치 
  - 수동 파티션 설정 -- home 2기가 , / 70기가 
  - NAT subnet IP 10.0.0.0
  - 네트워크 & hostname -- controller  설정 - 수동 / 10.0.0.100/ 24 10.0.0.2

- ```shell
  $ yum repolist  // 네트워크 확인 
  $ yum update -y // 커널을 포함한 업데이트 
  ```

- cenos 서비스 최적화 

  ```shell
  $ systemctl stop firewalld  //즉시 방화벽 내리기
  $ systemctl disable firewalld // 재부팅할때 자동으로 방화벽 부팅 안됨 
  $ systemctl disable NetworkManager
  $ systemctl stop NetworkManager // 원하지 않는 ip가 바뀔 수 있기때문에 disable하는게 좋음 
  $ setenforce 0   //SELinux 비활성화
  $ egrep '(vmx|svm)' /proc/cpuinfo //cpu의 가상머신 확인 -두가지의 패턴을 확인 할 수 있음 
  $ lscpu //cpu의 가상머신의 확인 
  ```

  - 방화벽 

    - centos6 --> iptables  -F -L  -- systemconfig firewall(그래픽버전)
    - centos7 --> firewall -cmd -- firewall config(그래픽 버전)

  - SELinux 

    레드헷 계열 Lable 기반   setenforce 0 으로 비활성화  getenforce 으로 확인 가능 

    vi /etc/selinux/config 파일에서 enable로 설정   // 재부팅해도 비활성화 유지 

- 호스트 정보 확인 

  ```shell
  $ cat /etc/centos-release 
  $ hostnamectl
  $ ip a
  ```

- NTP 서버 설정하기 (타임을 동기화 하기위한 서버 / 서버와 클라이언트의 타임 갭을 줄임 )

  - ntp  - 기존 패키지

  - chrony  -7버전으로 오면서 생긴 패키지

    ```shell
    $ yum install chrony -y 
    $ vi /etc/chrony.conf
    server 3.centos.pool.ntp.org iburst
    server 2.kr.pool.ntp.org ibutst 
    server 127.127.1.0
    allow 10.0.0.0/24
    $ yum install -y ntpdate  
    $ ntpdate 2.kr.pool.ntp.org
    $ date
    $ systemctl stop chronyd 
    $ systemctl start chronyd 
    $ systemctl enable chronyd 
    $ chronyc sources 
    ```

- vi /etc/hosts

  - 10.0.0.100 controller
  - 10.0.0.101 compute1

## 5. Packstack 으로  Openstack 설치 - rocky 

- Openstack repository(rdo) 등록 

  ```shell
  $ yum install –y centos-release-openstack-rocky
  $ yum repolist
  $ yum upgrade -y   // vm power off 
  파일 탐색기 controller(2G) openstack파일과 conpute1에 복사하기 
  $ yum install -y openstack-packstack*   //Pcckstack설치
  ```
  
- Packstack 사용하기

  ```shell
  $ packstack --gen-answer-file=/root/openstack.txt
  $ cp /root/openstack.txt /root/openstack.orig   //파일 카피 
  $ vi /root/openstack.txt 
  326 CONFIG_KEYSTONE_ADMIN_PW=abc123
  1185 CONFIG_PROVISION_DEMO=n
  11 CONFIG_DEFAULT_PASSWORD=abc123
  46 CONFIG_CEILOMETER_INSTALL=n
  50 CONFIG_AODH_INSTALL=n
  873 CONFIG_NEUTRON_OVS_BRIDGE_IFACES=br-ex:ens33
  $time packstack --answer-file=/root/openstack.txt
  ```

