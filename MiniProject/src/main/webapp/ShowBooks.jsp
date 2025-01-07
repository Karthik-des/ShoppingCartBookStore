<!DOCTYPE html>
<%@ page import="java.util.List" %>
<html>
<head>
  <style>
    body {
      font-family: Arial, sans-serif;
      background-color: #f9f9f9;
      margin: 0;
      padding: 20px;
    }

    h2 {
      text-align: center;
      color: #333;
    }

    table {
      width: 90%;
      margin: 20px auto;
      border: 1px solid red;
      border-collapse: collapse;
    }

    table, th, td {
      border: 1px solid red;
      border-collapse: collapse;
    }

    th, td {
      padding: 10px;
      text-align: center;
    }

    th {
      background-color: #f4f4f4;
    }

    .btn {
      display: inline-block;
      padding: 5px 10px;
      background-color: #007bff;
      color: white;
      border: none;
      border-radius: 5px;
      cursor: pointer;
    }

    .btn:hover {
      background-color: #0056b3;
    }

    .btn-cart {
      display: block;
      width: 150px;
      margin: 20px auto;
      background-color: #28a745;
      text-align: center;
      text-decoration: none;
      color: white;
      padding: 10px;
      border-radius: 5px;
    }

    .btn-cart:hover {
      background-color: #218838;
    }
  </style>
</head>
<body>
  <h2>Welcome to Karthik BookStore!!!</h2>
  <h2>Books available for <span style="color: green;">${CAT}</span> Category</h2>

  <!-- Show Cart Button -->
  <div>
    <a href="showMyCart.jlc" class="btn-cart">Show My Cart</a>
  </div>

  <!-- Books Table -->
  <table>
    <thead>
      <tr>
        <th>#</th>
        <th>Book Name</th>
        <th>Price (Rs.)</th>
        <th>Discount</th>
        <th>Action</th>
      </tr>
    </thead>
    <tbody>
      <%
        Object obj = session.getAttribute("BooksList");
        if (obj != null) {
          List<String> bookList = (List<String>) obj;
          int count = 1;
          for (String bname : bookList) {
      %>
      <tr>
        <td><%= count++ %></td>
        <td><%= bname %></td>
        <td>Rs. 250</td>
        <td>10% off</td>
        <td>
          <form action="addToCart.jlc" method="post">
            <input type="hidden" name="bname" value="<%= bname %>">
            <button type="submit" class="btn">Add To Cart</button>
          </form>
        </td>
      </tr>
      <% 
          }
        } else { 
      %>
      <tr>
        <td colspan="5" style="text-align: center; color: red;">No books available in this category.</td>
      </tr>
      <%
        } 
      %>
    </tbody>
  </table>
</body>
</html>
