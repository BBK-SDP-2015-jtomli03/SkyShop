<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page import="com.springapp.model.Product" %>
<%@ page import="com.springapp.model.ProductCatalogue" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html xmlns:th = "http://www.thymeleaf.org">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0"/>
  <title>The Home of Sky Accessories</title>

  <!-- CSS  -->
  <spring:url value="/resources/css/materialize/materialize.css" var="matCss" />
  <link href="${matCss}" type="text/css" rel="stylesheet" media="screen,projection">
  <spring:url value="/resources/css/main.css" var="mainCss" />
  <link href="${mainCss}" type="text/css" rel="stylesheet" media="screen,projection">
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
</head>
<body>
<nav class="white black-text" role="navigation">
  <div class="nav-wrapper container valign-wrapper">
    <a id="logo-container" href="/" class="brand-logo">
      <img src="${pageContext.request.contextPath}/resources/img/logo.png" alt="Sky Logo"/>
    </a>
    <ul id="slide-out" class="side-nav full">
      <li><a href="/login">Log In</a> </li>
      <li><a href="/basket">Shopping Basket</a> </li>
      <li disabled>&nbsp;</li>
      <li><a href="/">Home page</a></li>
      <li><a href="/account">Your Account</a></li>
      <li><a href="/show_all">All Products</a></li>
      <li><a href="/product">Example Product</a></li>
    </ul>
    <a href="#" data-activates="slide-out" class="button-collapse">
      <i class="large mdi-navigation-menu black-text"></i>
    </a>
    <ul id="basket-icon">
      <li><a href="/basket"><i class="material-icons black-text">shopping_basket</i></a></li>
    </ul>
  </div>
</nav>
