<!DOCTYPE html>
<html>
<head>
    <title>Book Manager</title>
    <blueprint:resources/>
    <link href="${resource(dir: 'css', file: 'app.css')}" type="text/css" rel="stylesheet">
</head>
<body>
    <div class="container">
        <div id="header-image" class="span-8">
        	<r:img uri="/images/books.jpg" alt="Book header image" id="header-image" />
        </div>
        <div id="header-text" class="span-16 last vertical-middle">
        	<h1>Books I've Read</h1>
        </div>
        <div id="subheader" class="span-24 last">
            <div class="span-4 border">
                <h3 class="alt">Book Title</h3>
            </div>
            <div class="span-4 border">
            	<h3 class="alt">Date Read</h3>
            </div>
            <div class="span-8 border">
                <h3 class="alt">Rating (1 lo - 10 hi)</h3>
            </div>
            <div class="span-4 border">
            	<h3 class="alt">AAA</h3>
            </div>
            <div class="span-4 last">
            	<h3 class="alt">BBB</h3>
            </div>
        </div>
        <div class="span-24 last"><hr></div>
        <g:each in="${ bookList }" var="book">
        <div class="span-24 last">
	        <div class="span-4"> 
				${book.title }
	        </div>
	        <div class="span-4">
	        	<g:formatDate format="MM/dd/yyyy" date="${book.readDate}"/>
	        </div>
	        <div class="span-8">
	            ${book.rating }
	        </div>
	        <div class="span-4">aaa</div>
	        <div class="span-4 last">bbb</div>
	    </div>
        </g:each>
    </div>
</body>
</html>
