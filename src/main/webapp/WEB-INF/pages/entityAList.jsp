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
  Time: 2:17 PM
--%>
<div>
    <div>
        <div>
            <!--Sidebar content-->
            Search: <input ng-model="query">
            Sort by:
            <select ng-model="orderProp">
                <option value="name">Alphabetical</option>
                <option value="age">Newest</option>
            </select>

        </div>
        <div>
            <ul>
                <li ng-repeat="entityA in entityAList.list | filter:query | orderBy:orderProp">
                    <a href="/entityAList/{{entityA.name}}">{{entityA.value}}</a>
                    <a href="/entityAList/{{entityA.name}}">{{entityA.name}}</a>
                </li>
            </ul>
        </div>
    </div>
</div>
