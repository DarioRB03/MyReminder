<?php
$nombre = $_POST[ 'nombre' ];
$correo = $_POST[ ' correo' ];
$message = $_POST[' message ' ];

$header = 'FROM' . $correo . " \r\n ";
$header = "X-Mailer : PHP/" .phpversion() . " \r\n";
$header = "Mini-Version : 1.0 \r\n";
$header = "Content-Type : text/plain";

$message = "Este formulario fue enviado por: " . $nombre . " \r\n";
$message .= "Su correo electronico es: " . $correo . " \r\n";
$message .= "Sus observaciones son : " . $observaciones . " \r\n";

$para = 'myreminder03@gmail.com';
$asunto = 'Nueva observacion de cliente en el formulario'

mail($para, $asunto , utf8_decode($message), $header);

header("Location:Formulario.html");
?>