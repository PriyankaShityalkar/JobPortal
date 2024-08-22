<%@page import="java.util.Base64"%>
<%@page import="Com.Entity.JobApplicationFormEntity"%>
<%@page import="java.util.List"%>
<%@page import="Com.JdbcConnection.JdbcConnection"%>
<%@page import="Com.Module.Promodule"%>
<html>
<head>
<meta charset="UTF-8">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/2.5.1/jspdf.umd.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/html2canvas/1.4.1/html2canvas.min.js"></script>
<style>
    /* Optional: Add some basic styles */
    .id-card {
        border: 1px solid #000;
        padding: 20px;
        width: 210mm; /* Width of A4 paper */
        height: 297mm; /* Height of A4 paper */
        box-sizing: border-box;
    }
    button {
        margin-top: 20px;
        padding: 10px 20px;
        font-size: 16px;
    }
</style>
</head>
<body>
<%
             try
             {
            	 Promodule P = new Promodule(JdbcConnection.getConnection());
            	 List<JobApplicationFormEntity> l = P.allrecord();
            	 for(JobApplicationFormEntity ja:l)
            	 {
             %>
<div class="id-card">
    <!-- Your ID card HTML content goes here -->
    <div class="signature-label"<%=Base64.getEncoder().encodeToString(ja.getJobApplicationUserResume()) %>>Principal's Signature</div>
    
    
</div>
 <%
            	 }
             }
             catch(Exception e)
             {
            	 e.printStackTrace();
             }
             %>
<button onclick="downloadIDCard()">Download ID Card</button>

<script type="text/javascript">
function downloadIDCard() {
    const { jsPDF } = window.jspdf;
    const idCardHTML = document.querySelector('.id-card');
    
    html2canvas(idCardHTML, { scale: 2 }).then(canvas => {
        const imgData = canvas.toDataURL('image/png');
        const pdf = new jsPDF('p', 'mm', 'a4');
        
        // Define PDF dimensions and margins
        const pdfWidth = pdf.internal.pageSize.getWidth();
        const pdfHeight = pdf.internal.pageSize.getHeight();
        const imgWidth = canvas.width * 0.264583; // Convert to mm
        const imgHeight = canvas.height * 0.264583; // Convert to mm
        
        // Calculate positions and scaling if needed
        const xOffset = (pdfWidth - imgWidth) / 2;
        const yOffset = (pdfHeight - imgHeight) / 2;
        
        // Add image to PDF
        pdf.addImage(imgData, 'PNG', xOffset, yOffset, imgWidth, imgHeight);
        pdf.save('id-card.pdf');
    }).catch(error => {
        console.error('Error generating PDF:', error);
    });
}
</script>
</body>
</html>