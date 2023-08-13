create database lab6Bai2;
use lab6Bai2
go
create table Standars(
	standardID nvarchar(30) primary key,
	fees float
)

create table Student(
	RegID int primary key identity,
	name nvarchar(50),
	address nvarchar(50),
	parentName nvarchar(50),
	phone nvarchar(10),
	standard nvarchar(30) foreign key references Standars(standardID),
	RegDate date
)
insert into Standars values('WEB1',9000)
insert into Standars values('WEB2',10000)
insert into Standars values('DEL1',11000)
insert into Standars values('DEL2',18000)
insert into Standars values('UDPM',15000)
insert into Standars values('MOB',12000)

INSERT INTO STUDENT
VALUES
(N'Võ Tín Nghĩa', N'23 Điện Biên Phủ, Duy Xuyên, Quảng Nam', N'Nguyễn Hoàng Thùy Linh', '0935019281', 'WEB1', '2000-1-1'),
(N'Hoàng Nhật Linh', N'89 Tôn Đản, Cẩm Lệ, Đà Nẵng', N'Hoàng Ánh Nam', '0123878564', 'WEB2', '2001-2-2'),
(N'Dương Tú Nhi', N'187 Nguyễn Hữu Thọ, Hải Châu, Đà Nẵng', N'Dương Tú Anh', '0912545232','MOB', '2002-3-3'),
(N'Nguyễn Hoàng Phong', N'362 Nguyễn Khuyến, Cầu Giấy, Hà Nội', N'Nguyễn Hoàng Dũng', '0932567567', 'UDPM', '2003-3-3'),
(N'Hoàng Yến Nhi', N'34 Hoàng Diệu, Tam Kỳ, Quảng Nam', N'Hoàng Anh Quân', '0803474832', 'DEL1', '2004-4-4'),
(N'Lê Thị Hằng', N'176 Hoàng Hoa Thám, Mộ Đức, Quảng Ngãi', N'Lê Thị Hoa', '0935456690', 'DEL2', '2003-5-5'),
(N'Ngô Ngọc Phước', N'272 Huỳnh Ngọc Huệ, Điện Bàn, Quảng Nam', N'Ngô Ngọc Long', '09083945', 'WEB2', '2002-6-6'),
(N'Phạm Hải', N'126 Hùng Vương, Thủ Đức, TP HCM', N'Phạm Khắc Hưng', '0912845263', 'DEl1', '2004-7-19');