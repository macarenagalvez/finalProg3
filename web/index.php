<?
    $conn =  mysqli_connect("127.0.0.1", "root", "", "jsp");

    if (!$conn) {
        die("Connection failed: " . mysqli_connect_error());
    }


    $sql = "SELECT * FROM estancia";
    $result = $conn->query($sql);
    // $mostrar = "<table border='1'><tr><td>ID</td><td>NOMBRE</td><td>DESCRIPCION</td><td>DESTACADA</td><td>CATEGORIA</td><td>DOMICILIO</td></tr>";
    if ($result->num_rows > 0) {
        // output data of each row
        while($row = $result->fetch_assoc()) {

            // $linea = "<tr><td> " . $row["id"] . "</td>" . "<td>" . $row["nombre"] . "</td>";
            echo "id: " . $row["id"]. " - Nombre: " . $row["nombre"]. " - " . $row['categoria'] . " - " . $row["descripcion"] . " - " . $row["domicilio"] . " - " . $row["destacada"]. "<br>";
            // $linea . "</tr>";
        }
        // echo $mostrar;
      } else {
        echo "0 results";
      }
      $conn->close();

?>
