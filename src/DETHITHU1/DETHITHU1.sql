create Database DETHITHU;
create table students(
masv varchar(7) primary key not null,
hoten nvarchar(45) ,
lop nvarchar(30)
)
INSERT INTO students (masv, hoten, lop) 
VALUES ('SV001', N'Nguyễn Văn A', 'CSE101'), ('SV002', N'Nguyễn Thị B', 'CSE102'), ('SV003', N'Trần Văn C', 'CSE103'),
('SV004', N'Trần Thị D', 'CSE104'), ('SV005', N'Lê Văn E', 'CSE105'), ('SV006', N'Lê Thị F', 'CSE106'), ('SV007', N'Phạm Văn G', 'CSE107'),
('SV008', N'Phạm Thị H', 'CSE108'), ('SV009', N'Hoàng Văn I', 'CSE109'), ('SV010', N'Hoàng Thị K', 'CSE110');