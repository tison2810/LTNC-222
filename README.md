# StudentManagement
#LTNC-222
read this please  

***Đây là phần mềm quản lí sinh viên***  
Dành cho người quản lí (admin) và sinh viên  

Người quản lí có username và password là "admin" và "advancedProgramming"  
Sinh viên có username là MSSV và password là tháng + MSSV + ngày + năm sinh  

Có 2 cách để chạy chương trình:  

Cách 1: Sử dụng Eclipse IDE và chạy bằng file Test.java -> Run as Java Application.  

Cách 2: Sử dụng VSCode và chạy bằng file Test.java chọn Run Java.

Cách 3: Export file Test ra file có đuôi .jar (đã đính kèm sẵn StudentManagement.jar)  
LƯU Ý: Nếu sử dụng cách 3, `java -version` và `javac -version` phải cùng phiên bản, đồng thời phải có JDK.  

MySQL được sử dụng thông qua XAMPP.  

Để sử dụng, vui lòng tham khảo source code: `jdbc:mysql://localhost:3306/test_1","root",""` do được kết nối với Database có tên là `test_1` và table là `qlsv`  

Table trên MySQL được tạo sẵn từ trước, ***không được tạo từ chương trình***, chương trình chỉ kết nối với Database. 

username là root và không có password (để trống).  

Link demo: https://drive.google.com/file/d/1rUH_azmQuc4bd_JiSaf4Z0iFw7d71L3U/view?usp=share_link  

Ngoài ra, về phàn `export` file csv lỗi font, có thể sửa bằng cách mở bằng Notepad++ và Encoding -> convert lại UTF-8  

Thực hiện bởi:  
Nguyễn Xuân An - 2112742  
Hoàng Minh Hải Đăng - 2110120  
Nguyễn Thái Sơn - 2112198  

Nếu có thắc mắc, vui lòng liên hệ qua mail: <son.nguyenthai@hcmut.edu.vn>  

thanks for reading  

chỉnh sửa lần cuối 21:18 04/05/2023

