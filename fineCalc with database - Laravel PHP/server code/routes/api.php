<?php

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Route;

/*
|--------------------------------------------------------------------------
| API Routes
|--------------------------------------------------------------------------
|
| Here is where you can register API routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| is assigned the "api" middleware group. Enjoy building your API!
|
*/

Route::middleware('auth:sanctum')->get('/user', function (Request $request) {
    return $request->user();
});

use App\Http\Controllers\CarmodelController;

Route::get('/carmodels', [CarmodelController::class, "allCarmodels"]);
Route::get('/carmodel/{id}', [CarmodelController::class, "getCarmodel"]);
Route::get('/carname/{id}', [CarmodelController::class, "getCarName"]);

Route::get('/makeOfModel/{id}', [CarmodelController::class, "makeOfModel"]);
Route::get('/makesStripped', [CarmodelController::class, "getMakesStripped"]);
Route::get('/makes', [CarmodelController::class, "getMakes"]);

Route::get('/modelsOfMakeStripped/{name}', [CarmodelController::class, "getModelsOfMakeStripped"]);

Route::get('/calculateFine/{titel}', [CarmodelController::class, "calculateFineOfModel"]);