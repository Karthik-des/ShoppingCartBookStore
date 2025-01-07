<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update Profile</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f8f9fa;
        }
        .form-container {
            max-width: 400px;
            margin: 50px auto;
            background: #fff;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="form-container">
            <h2 class="text-center">Update Profile</h2>
            <form action="UpdateServlet" method="post">
                <div class="mb-3">
                    <label for="username" class="form-label">Username (Read-only)</label>
                    <input type="text" id="username" name="username" class="form-control" 
                           value="${sessionScope.username}" readonly>
                </div>
                <div class="mb-3">
                    <label for="email" class="form-label">Email</label>
                    <input type="email" id="email" name="email" class="form-control" 
                           value="${sessionScope.email}" required>
                </div>
                <div class="mb-3">
                    <label for="name" class="form-label">Name</label>
                    <input type="text" id="name" name="name" class="form-control" 
                           value="${sessionScope.name}" required>
                </div>
                <button type="submit" class="btn btn-success w-100">Update</button>
            </form>
        </div>
    </div>
    
</body>
<div>
<a href="index.jsp"></a>
</div>
</html>
