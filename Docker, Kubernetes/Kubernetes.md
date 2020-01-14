# Kubernetes

> 쿠버네스트 : docker container 운영을 자동화하기 위한 컨테이너 오케스트레이션 틀 
>
> 스웜과 하는 일은 비슷하지만 더 간단하다. 

- 설치 

  - 쿠버네스트 -> 트레이> 도터아이톤> settiong>쿠버네스트

  - kubectl 

  - dashbord 설치

    ```
    $ kubectl apply -f 
    ```

    

-  주요 개념 

  node : 컨테이너가 배치되는 서버

  Namespace : 쿠버네스트 클러스터 안의 가상 클러스터

  Pod : 컨테이버 집합 중 가장 작은 단위, 컨테이너의 실행 방법  정의 

  replica set : 파드 복제

​       service : 외부에 배포하는 단위 (파드의 집합에 접근하기 위한 경로를 정의)

- 대시보드 설치 

  ```
  $ kubectl apply -f https://raw.githubusercontent.com/kubernetes/dashboard/v1.8.3/src/deploy/recommended/kubernetes-dashboard.yaml
  $ kubectl get pods --namespace=kube-system -l k8s-app=kubernetes-dashboard
  $ kubectl proxy 
  
  웹브라우저의 대시보드 보기 
  http://localhost:8001/api/v1/namespaces/kube-system/services/https:kubernetes-dashboard:/proxy/
  ```

- pod 올리기 

  > 컨테이너가 모인 집합체의 단위. 하나 이상의 컨테이너로 구성
  >
  > 고정 ip보다는 lable등을 사용한다
  >
  > 중복되지 않는 post 제공 
  >
  > 외부와 연결할려면 service가 필요하다 

  - `kubectl apply -f  *.yml`

  - 데시보드에서 `+create`

    ```
    apiVersion: v1
    kind: Pod
    metadata:
      name: hello-pod
      labels:
        app: hello
    spec:
      containers:
      - name: hello-container
        image: 0516khj2004/hello
        ports:
        - containerPort: 8000
    ```

  - 데시보드 > pod >exec   == `kubectl exec -it podid sh`

  - pod 리스트 확인 `kubectl get pods` 

  - 사용 할 수 있는 서비스 목록 확인 `kubectl get all` 

- service 올리기 

  > externalIPs: 외부랑 연결
  >
  > clustip : 내부랑 연결 

  ```
  apiVersion: v1
  kind: Service
  metadata:
    name: hello-svc
  spec:
    selector:
      app: hello
    ports:
      - port: 8200
        targetPort: 8000
    type: LoadBalancer
    externalIPs:
    - 59.29.224.29
  ```

  

