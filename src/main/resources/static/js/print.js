

function imprimer_bloc(titre, objet) {

var zone = document.getElementById(objet).innerHTML;
 

var fen = window.open("", "", "height=500, width=600,toolbar=0, menubar=0, scrollbars=1, resizable=1,status=0, location=0, left=10, top=10");
 

fen.document.body.style.color = '#000000';
fen.document.body.style.backgroundColor = '#FFFFFF';
fen.document.body.style.padding = "20px";
 

fen.document.title = titre;
fen.document.body.innerHTML += " " + zone + " ";
 

fen.window.print();
 

fen.window.close();
return true;
}

function printPartOfPage(elementId) {
	  var printContent = document.getElementById(elementId);
	            var printWindow = window.open('','','left=50000,top=50000,width=0,height=0');
	 
	            printWindow.document.write(printContent.innerHTML);
	            printWindow.document.close();
	            printWindow.focus();
	            printWindow.print();
	            printWindow.close();
}

function printPartOfPagee(elementId) {
var printContent = document.getElementById(elementId);
         var printWindow = window.open('','','left=50000,top=50000,width=0,height=0');

         printWindow.document.write(printContent.innerHTML);
         printWindow.document.close();
         printWindow.focus();
         printWindow.print();
         printWindow.close();
			
}

function printDiv(divName) {
    var printContents = document.getElementById(divName).innerHTML;
    var originalContents = document.body.innerHTML;

    document.body.innerHTML = printContents;

    window.print();

    document.body.innerHTML = originalContents;
}