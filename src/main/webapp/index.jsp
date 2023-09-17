<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Mail</title>
    <!-- icon resetCSS-->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.min.css">
    <!-- CSS -->
    <link rel="stylesheet" href="CSS/main.css">
    <link rel="stylesheet" href="CSS/base.css">
</head>
<body>
<div class="main">
    <div class="header">
        <div class="header__container grid__row">
            <div class="header__container--logo">
                <div class="header__container-menulogo">
                    <i class="fa-solid fa-bars"></i>
                </div>
                <div class="header__container--title">Mail</div>
            </div>

            <div class="header__container--searchbar">
                <div class="header__searchbar--btn">
                    <i class="fa-solid fa-magnifying-glass"></i>
                </div>

                <form class="header__searchbar--input" role="search">
                    <input type="text" name="" class="header__searchbar--input_field" placeholder="Search mail">
                </form>
            </div>

            <div class="header__container--profile">
                <div class="profile--icon">
                    <i class="fa-solid fa-user"></i>
                </div>
            </div>
        </div>
    </div>

    <div class="container">
        <nav class="container__sidebar">
            <a href="#first">
                <i class="fa-solid fa-pen"></i>
                <P>Compose</P>
            </a>
            <a href="#second">
                <i class="fa-solid fa-box"></i>
                <P>Mailbox</P>

            </a>
            <a href="#third">
                <i class="fa-solid fa-trash"></i>
                <P>Spam</P>

            </a>
            <a href="#fourth">
                <i class="fa-solid fa-paper-plane"></i>
                <P>Sent mail</P>

            </a>
        </nav>

        <div class="container__contetnt">
            <section id='first'>
                <h1>Compose</h1>
            </section>

            <section id='second'>
                <h1>Mailbox</h1>
            </section>

            <section id='third'>
                <h1>Spam</h1>
            </section>

            <section id='fourth'>
                <h1>Sent mail</h1>
            </section>
        </div>
    </div>
</div>
</body>
</html>