# 로그 생성기

여러 종류에 로그를 생성하는 프로젝트
* 파일
* 카푸카 (예정)

## 파일 로그
1. 도커 이미지로 만들어 특정 폴더로 로그가 쌓이도록 만든다.
   * mvn clean package 
   * docker build -t airtrack1234/log-generator -f .\Dockerfile .
   * docker push
   * 파일 기본 경로 : /server/log-generator/server-log
2. Filebeat, Promtail에서 긁어갈수 있는 용도로 생성한다.



