<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <header class="header white-bg">
            <div class="sidebar-toggle-box">
                <div data-original-title="Toggle Navigation" data-placement="right" class="icon-reorder tooltips"></div>
            </div>
            <!--logo start-->
            <a href="Index.jsp" class="logo">Medical<span>Recommend</span></a>
            <!--logo end-->

            <div class="top-nav ">
                <!--search & user info start-->
                <ul class="nav pull-right top-menu">
                    <li>
                        <input type="text" class="form-control search" placeholder="Search">
                    </li>
                    <!-- user login dropdown start-->
                    
                            <%if(session.getAttribute("UserName")!=null){
                                out.print("<li class='dropdown'>");
                                out.print("<a data-toggle='dropdown' class='dropdown-toggle' href='#'>");
                                out.print(session.getAttribute("UserName"));
                                out.print("<img alt='' src='img/avatar1_small.jpg'>");
                                out.print("</a>");
                                out.print("<ul class='dropdown-menu extended logout'><div class='log-arrow-up'></div><li><a href='login.html'><i class='icon-key'></i> Log Out</a></li></ul>");
                                
                            }
                            else{
                                out.print("<li>");
                                out.print("<a class='dropdown-toggle' href='Login.jsp'>Login</a></li>");
                                out.print("<li>");
                                out.print("<a class='dropdown-toggle' href='DoctorRegist.jsp'> Regist</a></li>");
                                
                            } %>
                    <!-- user login dropdown end -->
                </ul>
                <!--search & user info end-->
            </div>
        </header>
      <!--header end-->
      
      