# JAVA-WEB-BT
# Sinh viên thực hiện : Trình Văn Lưu 
# MSSV : 23110260
# Bài Tập Tuần 2 ( Ngày 27/08/2025)
## Mục tiêu 
Xây dựng chức năng đăng nhập cơ bản sử dụng:
  + JSP (giao diện hiển thị form login, thông báo lỗi/thành công).
  + Servlet (Controller) để xử lý request từ client.
  + Model (UserModel) để lưu trữ thông tin người dùng.
  + Service + DAO để kiểm tra tài khoản/mật khẩu trong Database.
## Thông tin Project 
DataBase có bảng [User_2] gồm 4 thuộc tính : 
+ id.
+ username.
+ fullname.
+ password.

Project thực hiện bắt đầu từ file login.inđex ( trong thư mục webapp).
Người xem có thể tạo Database mới có tên LapTrinhWeb_ChieuT3_Tuan2 và bảng [User_2] với 4 thuộc tính để test project.






# Bài tập Login (Cookies / Session) 

## Mục tiêu
Chạy demo login cơ bản với **Cookies** hoặc **Session**.  

Người dùng đăng nhập bằng **username** và **password** cố định. Với bài tập Cookies thì chỉ có login, còn Session thì gồm login và logout.

---

## Thông tin đăng nhập
- **Username:** Luuloneranger 
- **Password:** 123

## Lưu ý
- File login.html là điểm bắt đầu của demo Cookie.
  + Các file liên quan đến Coockie nằm trong package controller
- File loginSession.html là file khởi đầu cho việc demo Session
  + Các file liên quan đến Session năm trong package models
