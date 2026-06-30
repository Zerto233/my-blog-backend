# my-blog-backend

> 个人技术博客网站后端 API 服务

**在线 API**：[https://my-blog-backend-production-dbbd.up.railway.app](https://my-blog-backend-production-dbbd.up.railway.app)

## 技术栈
- Spring Boot 3
- MyBatis
- PostgreSQL
- JWT

## API 接口

| 方法   | 路径                 | 说明               |
| ------ | -------------------- | ------------------ |
| GET    | `/api/projects`      | 获取所有项目       |
| GET    | `/api/projects/{id}` | 获取单个项目       |
| POST   | `/api/projects`      | 新增项目（需认证） |
| PUT    | `/api/projects/{id}` | 更新项目（需认证） |
| DELETE | `/api/projects/{id}` | 删除项目（需认证） |
| POST   | `/api/admin/login`   | 管理员登录         |