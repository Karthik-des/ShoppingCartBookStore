<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>JLC BookStore</title>
  <style>
    /* General Styling */
    body {
      font-family: Arial, sans-serif;
      background: linear-gradient(45deg, #ff9a9e, #fad0c4, #fbc2eb);
      background-size: 300% 300%; /* Makes the gradient large enough for smooth animation */
      animation: backgroundAnimation 8s infinite alternate; /* Smooth color transition */
      margin: 0;
      padding: 0;
      display: flex;
      justify-content: center;
      align-items: center;
      min-height: 100vh;
    }

    h2 {
      text-align: center;
      color: white;
      animation: colorAnimation 4s infinite alternate; /* Changing text color */
    }

    /* Container Box Styling */
    .container {
      background-color: #fff;
      padding: 20px;
      width: 400px;
      border-radius: 8px;
      box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); /* Box shadow effect */
    }

    /* Message Styling */
    .message {
      display: block;
      text-align: center;
      color: red;
      font-size: 18px;
      margin-bottom: 20px;
    }

    /* Table and Form Styling */
    table {
      width: 100%;
    }

    label {
      font-size: 16px;
      color: #555;
    }

    select {
      width: 100%;
      padding: 8px;
      margin-top: 10px;
      margin-bottom: 20px;
      border: 1px solid #ccc;
      border-radius: 4px;
      font-size: 16px;
    }

    input[type="submit"] {
      width: 100%;
      padding: 10px;
      background-color: #007bff;
      color: white;
      font-size: 16px;
      border: none;
      border-radius: 4px;
      cursor: pointer;
      transition: background-color 0.3s ease; /* Smooth button hover effect */
    }

    input[type="submit"]:hover {
      background-color: #0056b3;
    }

    /* Animations */
    @keyframes backgroundAnimation {
      0% { background-position: 0% 50%; }
      100% { background-position: 100% 50%; }
    }

    @keyframes colorAnimation {
      0% { color: #ff9a9e; }
      50% { color: #fad0c4; }
      100% { color: #fbc2eb; }
    }
  </style>
</head>
<body>
  <div class="container">
    <!-- Header -->
    <h2>Welcome to JLC BookStore!!!</h2>
    <h2>Search Books Here</h2>
    <!-- Dynamic Message -->
    <span class="message">${MSG}</span>
    <!-- Form -->
    <form action="searchBooks.jlc" method="GET">
      <table>
        <tr>
          <td>
            <label for="category">Select Category:</label>
          </td>
        </tr>
        <tr>
          <td>
            <select id="category" name="category" required>
              <option value="">-----Select Category-----</option>
              <option value="Java">Java Programming</option>
              <option value="Python">Python Programming</option>
              <option value="Web">Web Development</option>
            </select>
          </td>
        </tr>
        <tr>
          <td>
            <input type="submit" value="Show Books" />
          </td>
        </tr>
      </table>
    </form>
  </div>
</body>
</html>
