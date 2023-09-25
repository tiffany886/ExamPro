DROP DATABASE IF EXISTS exam_pro;
CREATE DATABASE exam_pro;
use exam_pro;

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- 创建用户表
DROP TABLE IF EXISTS `User`;
CREATE TABLE User (
    UserID INT NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '用户ID',
    Username VARCHAR(255) NOT NULL COMMENT '用户名',
    Password VARCHAR(255) NOT NULL COMMENT '密码',
    Role INT NOT NULL COMMENT '身份'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户表';


-- 创建考试表
DROP TABLE IF EXISTS `Exam`;
CREATE TABLE Exam (
    ExamID INT NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '考试ID',
    ExamName VARCHAR(255) NOT NULL COMMENT '考试名称',
    ExamDescription VARCHAR(255) NOT NULL COMMENT '考试描述',
    StartTime DATETIME NOT NULL COMMENT '开始时间',
    EndTime DATETIME NOT NULL COMMENT '结束时间',
    PaperID INT NOT NULL COMMENT '试卷ID',
    FOREIGN KEY (PaperID) REFERENCES PaperManagement(PaperID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='考试表';

-- 创建考试报名表
DROP TABLE IF EXISTS `ExamRegistration`;
CREATE TABLE ExamRegistration (
    RegistrationID INT NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '报名ID',
    ExamID INT NOT NULL COMMENT '考试ID',
    UserID INT NOT NULL COMMENT '用户ID',
    FOREIGN KEY (ExamID) REFERENCES Exam(ExamID),
    FOREIGN KEY (UserID) REFERENCES User(UserID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='考试报名表';

-- 创建在线考试记录表
DROP TABLE IF EXISTS `ExamRecord`;
CREATE TABLE ExamRecord (
    RecordID INT NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '记录ID',
    ExamID INT NOT NULL COMMENT '考试ID',
    UserID INT NOT NULL COMMENT '用户ID',
    ExamDescription VARCHAR(255) NOT NULL COMMENT '考试描述',
    StartTime DATETIME NOT NULL COMMENT '开始时间',
    EndTime DATETIME NOT NULL COMMENT '结束时间',
    ObjectiveScore INT NOT NULL COMMENT '客观分',
    SubjectiveScore INT NOT NULL COMMENT '主观分',
    TotalScore INT NOT NULL COMMENT '总分',
    Status INT NOT NULL COMMENT '状态',
    FOREIGN KEY (ExamID) REFERENCES Exam(ExamID),
    FOREIGN KEY (UserID) REFERENCES User(UserID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='在线考试记录表';

-- 创建题目池表
-- 创建题目池表
DROP TABLE IF EXISTS `QuestionPool`;
CREATE TABLE QuestionPool (
    QuestionID INT NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '题目ID',
    QuestionType VARCHAR(255) NOT NULL COMMENT '题目类型',
    QuestionDescription TEXT COMMENT '题目描述',
    UserID INT NOT NULL COMMENT '所属用户ID',
    QuestionAnswer TEXT COMMENT '题目答案',
    CreateTime DATETIME NOT NULL COMMENT '创建时间',
    FOREIGN KEY (UserID) REFERENCES User(UserID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='题目池表';

# DROP TABLE IF EXISTS `QuestionPool`;
# CREATE TABLE QuestionPool (
#     QuestionID INT NOT NULL PRIMARY KEY COMMENT '题目ID',
#     QuestionType VARCHAR(255) NOT NULL COMMENT '题目类型',
#     QuestionDescription TEXT COMMENT '题目描述',
#     CreateTime DATETIME NOT NULL COMMENT '创建时间'
# ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='题目池表';

-- 创建题库管理表
DROP TABLE IF EXISTS `QuestionBank`;
CREATE TABLE QuestionBank (
    BankID INT NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '题库ID',
    BankName VARCHAR(255) NOT NULL COMMENT '题库名称',
    CreateTime DATETIME NOT NULL COMMENT '创建时间',
    UserID INT NOT NULL COMMENT '题库所属用户ID',
    FOREIGN KEY (UserID) REFERENCES User(UserID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='题库管理表';

-- 创建题库题目关联表
DROP TABLE IF EXISTS `BankQuestion`;
CREATE TABLE BankQuestion (
    LinkID INT NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '关联ID',
    BankID INT NOT NULL COMMENT '题库ID',
    QuestionID INT NOT NULL COMMENT '题目ID',
    FOREIGN KEY (BankID) REFERENCES QuestionBank(BankID),
    FOREIGN KEY (QuestionID) REFERENCES QuestionPool(QuestionID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='题库题目关联表';

-- 创建试题管理表
DROP TABLE IF EXISTS `QuestionManagement`;
# CREATE TABLE QuestionManagement (
#     QuestionID INT NOT NULL PRIMARY KEY COMMENT '试题ID',
#     UserID INT NOT NULL COMMENT '用户ID',
#     QuestionContent TEXT COMMENT '试题内容',
#     IsInBank BOOLEAN COMMENT '是否归类到题库',
#     CreateTime DATETIME NOT NULL COMMENT '创建时间',
#     FOREIGN KEY (UserID) REFERENCES User(UserID)
# ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='试题管理表';

-- 创建题目题库关联表
DROP TABLE IF EXISTS `QuestionBankAssociation`;
CREATE TABLE QuestionBankAssociation (
    AssociationID INT NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '关联ID',
    QuestionID INT NOT NULL COMMENT '试题ID',
    BankID INT NOT NULL COMMENT '题库ID',
    FOREIGN KEY (BankID) REFERENCES QuestionBank(BankID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='题目题库关联表';

-- 创建试卷管理表
DROP TABLE IF EXISTS `PaperManagement`;
CREATE TABLE PaperManagement (
    PaperID INT NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '试卷ID',
    PaperName VARCHAR(255) NOT NULL COMMENT '试卷名称',
    ObjectiveScore INT NOT NULL COMMENT '客观题分数',
    TotalScore INT NOT NULL COMMENT '总分',
    SubjectiveScore INT NOT NULL COMMENT '主观题分数',
    StartTime DATETIME NOT NULL COMMENT '考试开始时间',
    EndTime DATETIME NOT NULL COMMENT '考试结束时间',
    NumberOfExaminees INT NOT NULL COMMENT '考试人数',
    UserID INT NOT NULL COMMENT '创建人ID',
    Duration INT NOT NULL COMMENT '考试时长',
    FOREIGN KEY (UserID) REFERENCES User(UserID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='试卷管理表';

-- 创建试卷题目关联表
DROP TABLE IF EXISTS `PaperQuestion`;
CREATE TABLE PaperQuestion (
    LinkID INT NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '关联ID',
    PaperID INT NOT NULL COMMENT '试卷ID',
    QuestionID INT NOT NULL COMMENT '题目ID',
    QuestionType VARCHAR(255) NOT NULL COMMENT '题目类型',
    Score INT NOT NULL COMMENT '分数',
    MultipleChoiceOrder INT NOT NULL COMMENT '选择题顺序',
    ObjectiveOrder INT NOT NULL COMMENT '客观题顺序',
    FOREIGN KEY (PaperID) REFERENCES PaperManagement(PaperID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='试卷题目关联表';

-- 创建评卷管理表
DROP TABLE IF EXISTS `GradingManagement`;
CREATE TABLE GradingManagement (
    GradingID INT NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '评卷ID',
    PaperID INT NOT NULL COMMENT '试卷ID',
    ExamineeID INT NOT NULL COMMENT '考生ID',
    GraderID INT NOT NULL COMMENT '创建人ID',
    StartTime DATETIME NOT NULL COMMENT '开始评卷时间',
    EndTime DATETIME NOT NULL COMMENT '结束评卷时间',
    ObjectiveScore INT NOT NULL COMMENT '客观题分数',
    SubjectiveScore INT NOT NULL COMMENT '主观题分数',
    TotalScore INT NOT NULL COMMENT '总分',
    FOREIGN KEY (PaperID) REFERENCES PaperManagement(PaperID),
    FOREIGN KEY (ExamineeID) REFERENCES User(UserID),
    FOREIGN KEY (GraderID) REFERENCES User(UserID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='评卷管理表';


ALTER TABLE questionpool
    MODIFY COLUMN createTime TIMESTAMP DEFAULT CURRENT_TIMESTAMP;

ALTER TABLE questionbank
    MODIFY COLUMN createTime TIMESTAMP DEFAULT CURRENT_TIMESTAMP;


INSERT INTO User (Username, Password, Role)
VALUES
('zhhh', 'e1ee0203ab28bb206f7b557722882de1', 1);

# 题库
INSERT INTO QuestionBank (BankName,UserID)
VALUES
('英语题库', 1),
('数学题库', 1);

INSERT INTO QuestionPool (QuestionType, QuestionDescription, UserID, QuestionAnswer)
VALUES
('0', 'What is 2 + 2?', 1, '4'),
('0', 'What is the capital of France?', 1, 'Paris'),
('0', 'What is 3 x 3?', 1, '9');

Insert INTO bankquestion (BankID, QuestionID) VALUE (1 ,1);


Insert INTO bankquestion (BankID, QuestionID) VALUE (1 ,1);

# 触发器 自动计算总分
DELIMITER //
CREATE TRIGGER CalculateTotalScore
    BEFORE INSERT ON PaperManagement
    FOR EACH ROW
BEGIN
    SET NEW.TotalScore = NEW.ObjectiveScore + NEW.SubjectiveScore;
END;
//
DELIMITER ;

# 触发器：自动计算考试结束时间
DELIMITER //
CREATE TRIGGER CalculateEndTime
    BEFORE INSERT ON PaperManagement
    FOR EACH ROW
BEGIN
    SET NEW.EndTime = DATE_ADD(NEW.StartTime, INTERVAL NEW.Duration MINUTE);
END;
//
DELIMITER ;

INSERT INTO PaperManagement (paperName, objectiveScore, subjectiveScore, startTime, numberOfExaminees, userID,Duration)
    value ('小升初卷子',40,60,'2023-4-5 14:00:00',40,1,120);

# 试卷
INSERT INTO PaperManagement (PaperName, ObjectiveScore, SubjectiveScore, StartTime, NumberOfExaminees, UserID, duration)
VALUES
('英语四六级试卷', 20, 30,'2023-9-22 13:00:00', 100, 1, 120),
('教资科一考试试卷', 25, 35, '2023-9-23 13:00:00', 120, 1, 60),
('蓝桥杯考试', 18, 27, '2023-9-24 13:00:00',  90, 1, 120);

