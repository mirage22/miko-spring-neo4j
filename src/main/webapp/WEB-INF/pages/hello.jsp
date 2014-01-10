<%--
* The MIT License
*
* Copyright 2014 Miroslav Kopecky.
*
* Permission is hereby granted, free of charge, to any person obtaining a copy
* of this software and associated documentation files (the "Software"), to deal
* in the Software without restriction, including without limitation the rights
* to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
* copies of the Software, and to permit persons to whom the Software is
* furnished to do so, subject to the following conditions:
*
* The above copyright notice and this permission notice shall be included in
* all copies or substantial portions of the Software.
*
* THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
* IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
* FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
* AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
* LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
* OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
* THE SOFTWARE.
*/
  Created by IntelliJ IDEA.
  User: miroslavkopecky
  Date: 1/6/14
  Time: 2:16 PM
--%>
<html lang="en" ng-app="sMongoApp">
<head>
    <meta charset="utf-8">
    <title>Spring Neo4J Demo</title>

    <link rel="stylesheet" href="/lib/bootstrap/css/bootstrap.min.css" >
    <link rel="stylesheet" href="/lib/bootstrap/css/bootstrap-theme.min.css" >

    <script src="/lib/angularjs/angular.js"></script>
    <script src="/lib/angularjs/angular-animate.js"></script>
    <script src="/lib/angularjs/angular-resource.js"></script>
    <script src="/lib/angularjs/angular-route.js"></script>
    <script src="/lib/jquery/jquery-1.10.2.min.js"></script>

    <script src="/app/js/app.js"></script>
    <script src="/app/js/controllers.js"></script>
    <script src="/app/js/filters.js"></script>
    <script src="/app/js/services.js"></script>
</head>
<body>
	<h1>${message}</h1>
    <div>
        <div ng-view></div>
    </div>
</body>
</html>