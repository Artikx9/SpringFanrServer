<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Admin Panel</title>
    <link href="../libs/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="../libs/css/style.css" media="all">
    <style>
        .jsontotable table, .jsontotable th, .jsontotable td {
            border: 1px solid black;
            margin: 10px;
        }

        code {
            white-space: normal;
        }
        body {
            background: #f4f7f8;
        }
        tbody tr:hover {
            color:#fa002a; /* Цвет текста при наведении */
        }
    </style>
    <script type="text/javascript" src="../libs/js/jquery-1.10.2.min.js"></script>
    <script type="text/javascript" src="../libs/js/jquery.jsontotable.min.js"></script>
    <script type="text/javascript" src="../libs/js/main.js"></script>
</head>
<body>
<div class="outer">
    <div class="form-style-5">
        <input type="button" value="Get All Users" onclick="JsonConverter(getAllUser())">
    </div>
<div class="form-style-5">
<p>Search user:</p>
<p><input id="search" type="text" size="40"></p>
<p><input type="submit" value="Find" onclick="JsonConverter(findUser())"></p>
</div><div class="form-style-5">
<p>Delete user:</p>
<p><input id="delete" type="text" size="40"></p>
        <p><input type="submit" value="Delete" onclick="DeleteUser()" ></p></div>
</div></div>
<div class="container">
    <div id="jsontotable-str" class="jsontotable"></div>
</div>

</body>
</html>
