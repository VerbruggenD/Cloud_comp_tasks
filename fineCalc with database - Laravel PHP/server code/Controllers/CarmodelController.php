<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;

use App\Models\Carmodel;
use App\Models\Carmake;

class CarmodelController extends Controller
{
    function allCarmodels() {
        return Carmodel::all();
    }

    function getCarmodel($id) {
        return Carmodel::find($id);
    }

    function getCarName($id) {
        $car = Carmodel::all() -> find($id);
        return  $car -> make -> name . " " . $car -> titel;
    }

    function makeOfModel($id) {
        return Carmodel::all() -> find($id) -> make;
    }

    function modelsOfMake($make_id) {
        return Carmodel::where('make_id', $make_id) -> get();
    }

    function getMakesStripped() {
        return Carmake::select('id', 'name') -> get();
    }

    function getMakes() {
        return Carmake::all();
    }

    function getModelsOfMakeStripped($name) {
        $make =  Carmake::where('name', $name) -> first() -> id;
            return Carmodel::where('make_id', $make) -> select('id', 'titel') -> get();
    }

    function getFineOffsetOfModelId($model_id) {
        return Carmodel::where('id', $model_id) -> get() -> fineOffset;
    }

    function getAvgFineOfMakeId($make_id) {
        return Carmake::where('id', $make_id) -> get() -> avgFine;
    }

    function getModelIdOfModelName($model_name) {
        return Carmodel::where('titel', $model_name) -> first() -> id;
    }
    
    function getMakeIdOfModelId($model_id) {
        return Carmodel::where('id', $model_id) -> first() -> make_id;
    }

    function calculateFineOfModel($titel) {
        $model_id = Carmodel::where('titel', $titel) -> first() -> id;
        $make_id = Carmodel::where('id', $model_id) -> first() -> make_id;
        $avgFine = Carmake::where('id', $make_id) -> first() -> avgFine;
        $fineOffset = Carmodel::where('id', $model_id) -> first() -> fineOffset;
        return $avgFine + $fineOffset;
    }
}
