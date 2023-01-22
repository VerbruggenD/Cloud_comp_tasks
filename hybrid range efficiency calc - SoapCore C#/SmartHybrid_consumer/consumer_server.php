<?php
    // get the form data

    $makeHybridParams = array(
        'e_avg_consum_highway' => $_POST['e_highway'],
        'e_avg_consum_city' => $_POST['e_city'],
        'e_avg_consum_country' => $_POST['e_country'],
        'p_avg_consum_highway' => $_POST['p_highway'],
        'p_avg_consum_city' => $_POST['p_city'],
        'p_avg_consum_country' => $_POST['p_country'],
        'e_capacity' => $_POST['e_capacity'],
        'p_capacity' => $_POST['p_capacity']
    );

    // $petrolParams = array(
    //     'p_avg_consum_highway' => $_POST['p_highway'],
    //     'p_avg_consum_city' => $_POST['p_city'],
    //     'p_avg_consum_country' => $_POST['p_country'],
    //     'p_capacity' => $_POST['p_capacity']
    // );

    // Soap consumption
    $options = array(
        'cache_wsdl' => 0,
        'trace' => 1,
        'stream_context' => stream_context_create(array(
              'ssl' => array(
                   'verify_peer' => false,
                    'verify_peer_name' => false,
                    'allow_self_signed' => true
              )
        )),
        );

    $result_page_container_begin = "<!doctype html><html><head><link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\" integrity=\"sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z\" crossorigin=\"anonymous\"><title>Smart Hybrid range efficiency</title></head><body><div class=\"jumbotron text-center\"><h1>Smart hybrid efficiency calculator</h1></div><div class=\"container\"><div class=\"row\"><div class=\"col-xs-6\">";
    $result_page_container_end = "</div></body></html>";

    $client = new SoapClient("https://smarthybridsoap.azurewebsites.net/Service.asmx", $options);
        // http://localhost:5259/Service.asmx
        //print_r($client->__getFunctions());
        // print("<hr/>");
        // print_r($client->__getTypes());
        // print("<hr/>");

        // print_r($electricParams);
        // $breukResponse = $client->maakBreuk($breukParams);
        // print_r($breukResponse);

        // $teller = $breukResponse->maakBreukResult->Teller;
        // print("<hr/>");
        // print_r($teller);

        $makeHybridResponse = $client->makeHybrid($makeHybridParams);

        //print_r($calcEfficientResponse);

        $resultObject = $makeHybridResponse->makeHybridResult;

        print_r($resultObject->electric);

        $hybrid_mode = "New hybrid";
        $parameters = "Test voor parameters";

        $result_text = "<h2>New hybrid</h2><p><h3>Electric:</h3><br><p>Highway: {{ e_highway }}, City:  {{ e_city }}, Country: {{ e_country }} </p><p>Capacity: {{ e_capacity }}</p></p><p><h3>Petrol:</h3><br><p>Highway: {{ p_highway }}, City:  {{ p_city }}, Country: {{ p_country }}</p><p>Capacity: {{ p_capacity }}</p></p>";

        $result_text = str_replace("{{ e_highway }}", $resultObject->electric->avg_consum_highway, $result_text);
        $result_text = str_replace("{{ e_city }}", $resultObject->electric->avg_consum_city, $result_text);
        $result_text = str_replace("{{ e_country }}", $resultObject->electric->avg_consum_country, $result_text);
        $result_text = str_replace("{{ e_capacity }}", $resultObject->electric->capacity, $result_text);

        $result_text = str_replace("{{ p_highway }}", $resultObject->petrol->avg_consum_highway, $result_text);
        $result_text = str_replace("{{ p_city }}", $resultObject->petrol->avg_consum_city, $result_text);
        $result_text = str_replace("{{ p_country }}", $resultObject->petrol->avg_consum_country, $result_text);
        $result_text = str_replace("{{ p_capacity }}", $resultObject->petrol->capacity, $result_text);

        print_r($result_page_container_begin);

        print_r($result_text);

        print_r($result_page_container_end);
?>