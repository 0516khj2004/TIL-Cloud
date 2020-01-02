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
  >  scale out  : 박스 밖에서 박스 단위로  (인스턴스 스냅샷) [정리문서](https://m.blog.naver.com/islove8587/220548900044)
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

- cenos 서비스 최적화 - host 베이스 방화벽 

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
    $ systemctl start chronyd  // service network restart(7이하 명령어)
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
  
- Packstack 사용하기( 소규모 openstack 을 구성할 때 유용하다 )

  ```shell
  $ packstack --gen-answer-file=/root/openstack.txt
  $ cp /root/openstack.txt /root/openstack.orig   //파일 카피 
  $ vi /root/openstack.txt 
  326 CONFIG_KEYSTONE_ADMIN_PW=abc123
  1185 CONFIG_PROVISION_DEMO=n
  11 CONFIG_DEFAULT_PASSWORD=abc123
  46 CONFIG_CEILOMETER_INSTALL=n
  50 CONFIG_AODH_INSTALL=n
  873 CONFIG_NEUTRON_OVS_BRIDGE_IFACES=br-ex:ens33  // 네트워크제공 br-ex (하위 swift)
  $ time packstack --answer-file=/root/openstack.txt
  
  ** 10.0.0.100 // admin, abc123 openstack dashbord  접속 가능 **
  ```
  
- 확인하기

  - /etc/sysconfig/nework-sctipts/

    cat ifcfg-ens33  -> DEVICE = ens33 ( ip a 의 ens33과 같아야한다.)

    cat ifcfg-br-ex 

  - ovs-vsctl show  // ip a보다 더 정밀함 

  - cd

    cat keystonerc_admin -> export(로컬변수를 글로벌 변수로 바꿈 )  //username, pw , 주소 확인가능 

## 6. 사용자 관점에서 openstack dashbord 서비스 이용 

> all -in -node

### dashbord 메뉴얼

- 인증 (keynote)

  - 프로젝트 -  (리소스 quotas가 설정된) 사용자 그룹
  - 그룹
  - 사용자 

- 관리 - anmin(관리자 계정)인 경우만 사용 가능 

  - copmute (nova) 

    - 호스트 집합 - 가용성 존 (A.Z) 사용자가 선택 할 수 있는 단위<- intetnal , nova

      ​					 - 호스트 집합 사용자 볼 수 없음, compute host 관리 목적    

    - 인스턴스(실제 nova) -관리목적 Iaas 

    - 이미지 (glance)

    - flavor -aws의 인스턴스 타입을 openstack에서는 flavor 라고 한다.

  - 볼륨(cinder)

  - 네트워크(Neutron)

  - 시스템

    - 시스템정보  - compute의 4가지는 꼭 up 상태여야한다. 

- 프로젝트 - 사용자 목적으로 

### openstack 용어 정리 

- 프로젝트-cloud 사용자group에Quota적용
- Tenant -cloud 사용자그룹(project)
- Flavor-VM profile
- Image -Instance에연결될OS 설치이미지
- Instance -VM
- Key pair-DER/PEM/X.509로 인코딩된 넷스케이프 인증서 사용자가VM instance에접속시 사용

### Horizon으로 사용 및 관리하기 

#### 관리자모드

- 1. 프로젝트 생성
     - _member_ 일반 사용자 
- 2. 사용자 생성
     - 사용자 stack1 
     - 관리자 mgr1 
- 3. Flavor 생성
     - a.tiny pro1에 접근 권한 줌
     - a.nano  any(모두)에게 권한 줌 

#### self-service (인스턴스 생성을 위한 작업)

- 4. network 생성

     |  IP 4   |   A   |       B        |           C            |
     | :-----: | :---: | :------------: | :--------------------: |
     |         | 0-127 |    128-191     |        192-223         |
     | 사설 ip |  10   | 172-16.~172.31 | 182.168.0 ~182.168.255 |

     사설 ip를 가지고 있지만 공인 ip로 외부로 나간다.

     - Fixed IP 용: int1->subint1->192.168.0.0/24,gw:192.168.0.254,dns:10.0.0.2,dhcp 활성화)

     - Floating IP용: ext1->subext1->10.0.0.0/24, gw: 10.0.0.2, dns:10.0.0.2, dhcp X, 사용 IP pool(10.0.0.210,10.0.0.220),외부네트워크

- 5. router  생성

     - router1 생성

     - 게이트웨이 설정 (외부 네트워크과 router간 연결)  -- 외부 pool (ip 210~220 사이 자동 할당)

       관리자 모드 ext1 네트워크편집 - 공유, 외부 네트워크 연결 (지구본 모양)

       사용자 모드 라우터 - 게이트웨이편집 ext1로 설정

     - 인터페이스 추가(내부 네트워크와 router간 연결 ) - 내부 (192.168.0.254 고정)

       네트워크 토폴리지 - 라우터클릭 > 인터페이스 추가 int1 (ip비워두기-192.168.0.254 자동 할당)

- 6. security group 생성

     - 호스트 기반 방화벽( 기본  ) - 외부 통신이 가능한 보안 그룹 생성 (화이트 리스트 정책)

       보안그룹 생성(class1)

       - http, ssh , all icmp(ping test가능 하도록 ) - CIDR(누구나 들어옴 )  

       보안그룹 생성 (DBsg) 

       - ssh , mysql  - 보안그룹 class1

     - 네트워크 기반 방화벽( 선택 )

- 7. key pair 생성 -ssh에서 해당 클라우드 에 다이렉트로 접근해서 관리하기 위해서 
     -  키 페어 생성 (stack1-key1)  - 개인키 다운로드 됨 / 공개키는 ~/.ssh/authoriced_keys 에 저장됨 

- 8. floation ip 생성 (=공인 ip = aws의 EIP    vs  *fixed ip 사설* )
     - 프로젝트에 ip할당  -ext1

- 9. image 생성(가상머신의 root설치 이미지)
     - 이미지 생성(class) -cirros -포멧 QCOW2

#### compute service 

- 10. instance 생성 - class_instance
      - 소스 - 이미지 ,새로운 볼륨 생성 아니요(nova storage)
      
      - flavor - a.nano
      
      - network - int1
      
      - 보안 그룹 - class1
      
      - 키 -stack-key1
      
      - 콘솔창  cirros / cubswin:)  
      
        ```shell
	      Xshell에서 cirros 접속하기 
	      $ ip netns
	      $ ip netns exec qrouter-a1b0c327-247a-4bb3-912d-08e3e9947408 ssh cirros@10.0.0.210
	      $ id        
	    $ hostname  
	      $ free     // 메모리 정보 확인 
	    $ lsblk   // 디스크확인
		  $ ip a    // ip확인 
		  ```
		- 유동 ip설정 
		- controller cmd 창에서 오픈 스택 상태 확인 
	    
	    ```shell
	    $ yum install -y openstack-utils    // 오류 찾기 위한 설치 
	    $ openstack-status   // 오류확인
	    $ openstack-service  restart(stop, start) nova(neuturon,,)
	    ```
	
- 11. volume/snapshot 생성

      - 볼륨 생성 (vol1)  - > 볼륨 연결 관리 -> 인스턴스에 연결     //블록 기반 스토리지 

        `$ lsblk` 확인 -> vdb 붙어 있는지 확인 가능

      - key 기반 instance에 접속 (controller 에서)
      
         ```shell
      $ cd /mnt/hgfs/share_linux
      $ cp user1-key1.pem /root
      $ chmod 600 /root/user1-key1.pem
      $ cd /root
      $ ip netns exec qdhcp-9b3ff3ab-716e-48e2-a23e-0dcdc8686311 ssh -i user1-key1.pem cirros@10.0.0.213
         ```
      
      - snapshot 생성 - 백업 (원본이 문제가 있거나, 복제를 하기 위해서 백업을 함 )
        - 볼륨(vdb cinder 백업 ) - 스냅샷 생성 -> 복구 (스냅샷 생성 )
        - 인스턴스(vda rootdisk - nova 벡업) - 스냅샷 생성 (이미지만듬)- 인스턴스 생성 가능 

- 12. object storage 사용(Swift)

      - 오프젝트 스토리지 - 컨테이너 생성 (c1)  -공용x  

        폴더 생성 (KOO>download ) -> 업로드 (cirros)

      - 컨테이너 생성(c2) - 공용 