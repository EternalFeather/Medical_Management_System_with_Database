医疗管理系统
===
# Introduction
本系统主要是基于 `Struts2 MVC架构` + `mysql资料库` 共同开发的医疗信息管理系统模型。利用JSP打造简易的网页与接口，让用户能够通过系统纪录和查询医疗的细节流程。

# Environment
- `操作系统`：Windows10
- `资料库`：Mysql
- `IDE`：Eclipse
- `开发语言`：Jsp + Sql + Java

# SQL Table
资料库端分为五个Table，分别为 `Department`、`Employee`、`Hospital`、`Patient` 和 `Report`。

## Attribute Introduction

**Hospital Table:** 記錄醫院的具體信息
- Hospital_ID:每間醫院的編號（唯一）
- Hospital_Name:醫院的名稱
- Hospital_Address:醫院的地理位置
- Hospital_Scale:醫院的規模大小

**Department Table:** 記錄醫院里各個不同部門的具體信息
- Department_ID:醫院裏面不同部門的編號（唯一）
- Department_Subject:部門的名稱
- Department_People:部門的人數
- Field:部門所掌管的職能

**Employee Table:** 記錄醫院工作人員的具體信息
- Doctor_ID:每個員工的編號（唯一）
- Doctor_Name:員工的姓名
- Doctor_Age:員工的年齡
- Doctor_Specialty:員工的專長

**Patient Table:** 記錄病人的具體信息
- Patient_ID:每個病人的編號（唯一）
- Patient_Name:病人的姓名
- Patient_Age:病人的年齡
- Patient_Disease:病人的癥狀

**Report Table:** 記錄病人病歷記錄的具體信息
- Report_ID:每個病歷記錄的編號（唯一）
- Report_Disease:病歷記錄的病人癥狀
- Report_PatientName:病歷記錄的病人姓名
- Report_Medicine:病歷記錄的病人用藥情況

# ER Diagram

![](https://i.imgur.com/qdBYNZI.png)

# Relation Schema
| Hospital Schema |  |  |  |
|:-----------:|:-----------:|:-----------:|:-----------:|
| Hospital_ID  | Hospital_Name | Hospital_Address | Hospital_Scale |

| Department Schema |  |  |  |
|:-----------:|:-----------:|:-----------:|:-----------:|
| Department_ID | Department_Subject | Department_People | Field |

| Employee Schema |  |  |  |
|:-----------:|:-----------:|:-----------:|:-----------:|
| Doctor_ID | Doctor_Name | Doctor_Name | Doctor_Specialty |

| Patient Schema |  |  |  |
|:-----------:|:-----------:|:-----------:|:-----------:|
| Patient_ID | Patient_Name | Patient_Age | Patient_Disease |

| Report Schema |  |  |  |
|:-----------:|:-----------:|:-----------:|:-----------:|
| Report_ID | Report_Disease | Report_PatientName | Report_Medicine |

# Relationship Introduction

- 每個醫院都會有許多不同的部門，每個部門都是隸屬於某一家醫院。
- 每個醫院部門都會招聘不同數量的員工，未退休的員工會屬於某一個部門。
- 所有負責醫療工作的員工都會給病人開具病歷證明，所有的病歷證明都是由醫療工作員工開具的。
- 所有的病人都有自己的病歷記錄，所有的病歷記錄記錄著該病人的醫療情況。
- 負責醫療工作的員工會給病人看病，同時醫院的員工也有可能是病人。

# Usage

配置好sql和server之后，就可以通过localhost或者IP来访问系统网址了，这里用的是Tomcat Server來訪問資料庫系統首頁。。

![](https://i.imgur.com/OAdFgoI.png)

![](https://i.imgur.com/czWAFBo.png)

左邊的功能列表可以選擇需要操作的Entity進行不同的資料庫操作。

![](https://i.imgur.com/ukIeIjX.png)

以醫院管理為例，進入醫院管理操作介面，系統會自動列出所有的數據庫資料。點擊左上角的**添加**按鈕可以添加新的醫院信息到database；同時可以通過**Search**的選項來索引資料庫裏面的資料；點擊操作欄位的**修改和刪除**可以分別對相應的資料進行修改和刪除；最後點擊右上角的**手動修改和查詢**可以分別通過手動輸入SQL指令來進行修改動作（insert，delete，update）和查詢動作（select）。

- 添加介面：

![](https://i.imgur.com/PDo43C2.png)

可以**添加**醫院的相關信息到數據庫。
- 選擇操作：

![](https://i.imgur.com/mYQk0G0.png)

系統會給出相應的**檢索**結果：

![](https://i.imgur.com/UGf1VbP.png)

- 修改和刪除：

![](https://i.imgur.com/9jEEf1k.png)

點擊修改操作系統會自動捕捉當前的資料信息，方便進行**修改**。

![](https://i.imgur.com/EZVj52s.png)

點擊刪除操作系統會提示**是否刪除**，點擊確定則會從資料庫移除相應信息。

- 手動修改和刪除：

![](https://i.imgur.com/eknZV1t.png)

![](https://i.imgur.com/fqo6fRa.png)

點擊**手動修改和刪除**操作，系統會跳出相應的輸入框，可以通過手動輸入SQL指令來進行Select檢索或者Insert，Update，Delete等操作。

- Nested Query和Aggregate Query（以醫生管理為例）：
點擊Nested Query會跳轉至如下畫面。

![](https://i.imgur.com/9P6SJ1w.png)

分別點擊不同的按鈕可以**跳轉**至相應功能對應的介面。

![](https://i.imgur.com/Cp7doj5.png)

通過選項可以自動通過Button的方式呼叫資料庫，通過sql指令也可以進行資料庫的操作。

![](https://i.imgur.com/df2ElPC.png)

通過選項操作同樣可以用button的方式呼叫資料庫操作，sql指令同樣也能夠進行相應的操作。（注：在sql對於Aggregate操作過程中需要對應下方的欄位進行as重命名）

# KeyWords

###### tags: `Database` `System` `Struts MVC`
