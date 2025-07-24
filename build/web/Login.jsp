<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Đăng nhập hệ thống</title>
    <!-- Bootstrap 5 CDN -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        :root {
            --primary: #2e7d32; /* Đậm hơn */
            --secondary: #1b5e20;
            --light: #f2f2f2;
            --dark: #333;
            --text: #212121;
        }

        body {
            font-family: 'Roboto', sans-serif;
            background: linear-gradient(to right, #e0f2f1, #ffffff);
            color: var(--text);
            padding-top: 80px;
        }

        .login-container {
            max-width: 420px;
            margin: auto;
            padding: 40px;
            background-color: white;
            border: 2px solid var(--primary);
            border-radius: 16px;
            box-shadow: 0 10px 20px rgba(0, 0, 0, 0.12);
        }

        .login-container h2 {
            text-align: center;
            color: var(--primary);
            margin-bottom: 30px;
        }

        .form-control:focus {
            border-color: var(--primary);
            box-shadow: 0 0 8px rgba(46, 125, 50, 0.4);
        }

        .btn-primary {
            background-color: var(--primary);
            border-color: var(--primary);
        }

        .btn-primary:hover {
            background-color: var(--secondary);
            border-color: var(--secondary);
        }

        .error-message {
            color: red;
            text-align: center;
            margin-top: 10px;
        }

        .form-floating > label {
            color: #6c757d;
        }
    </style>
</head>
<body>

<div class="login-container shadow">
    <h2>Đăng nhập hệ thống</h2>
    <form action="Login" method="post">
        <div class="form-floating mb-3">
            <input type="text" class="form-control" id="username" name="username" placeholder="Tên đăng nhập" required>
            <label for="username">Tên đăng nhập</label>
        </div>

        <div class="form-floating mb-4">
            <input type="password" class="form-control" id="password" name="password" placeholder="Mật khẩu" required>
            <label for="password">Mật khẩu</label>
        </div>

        <div class="d-grid">
            <button type="submit" class="btn btn-primary btn-lg">Đăng nhập</button>
        </div>

        <p class="error-message">${error}</p>
    </form>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
