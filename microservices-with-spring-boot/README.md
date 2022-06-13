# :bank: Building Microservices With Spring Boot
Code for Building Microservices With Spring Boot

# Application's architecture :
...
<img src="https://camo.githubusercontent.com/56c1b92389855e9bd28ec9c47bd0d0ff9b96ab025fd7863501dbf136502b1847/68747470733a2f2f756361726563646e2e636f6d2f35303831633736342d663561632d346362372d626430382d3666393032643835303037312f"  width="800" height="500">

<img src="https://mblogthumb-phinf.pstatic.net/MjAxODA0MTNfMjM4/MDAxNTIzNTc4MDI5ODkx.KmsVMVflycS-rGPKdT0wpUBMPLoSsH-_K0BGtllkIcog.n8Ja4nGAb1JxoK3QeKlcRYcNcLuuvpbJCc261Ju3wu4g.PNG.sabisung/Screenshot_2018-04-13_at_09.06.38.png?type=w800"  width="800" height="500">

```
cd project folder
mvn clean install
```

# account-Service : 

| Service         | EndPoint                                       | Method | Description           |
|-----------------|------------------------------------------------|:------:|-----------------------|
| Account Command | /account/addAccount                            |  POST  | add an account        |
| Account Command | /account/getAll                                |  POST  | get account list      |

```
POST :  http://localhost:8045/account/addAccount
{ 
        "name": "SSS apply",
        "type": "commercial"
}
```

```
GET : http://localhost:8045/account/getAll
```

>ActiveMQ 5 [downloaded](https://activemq.apache.org/), unzip the file. 

```
go to the bin\win64 folder 
run activemq start 
```

>ActiveMQ WebConsole (admin)  : http://127.0.0.1:8161/ 

```
👨 user: admin
🔑 password: admin
```

# send to credit service : 

| Service         | EndPoint                                       | Method | Description           |
|-----------------|------------------------------------------------|:------:|-----------------------|
| Account Command | /account/sendToCredit/1                        |  GET   | send to credit service|

```
GET : http://localhost:8045/account/sendToCredit/1
```

# credit - services :

| Service         | EndPoint                                       | Method | Description           |
|-----------------|------------------------------------------------|:------:|-----------------------|
| credi Command   | /credit/getCredits                             |  GET   | get credit List       |

```
http://localhost:8050/credit/getCredits
```