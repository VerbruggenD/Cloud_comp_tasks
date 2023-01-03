<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

use App\Models\Carmodel;

class Carmake extends Model
{
    use HasFactory;

    public function carmodels() {
        return $this->hasMany(Carmodel::class);
    }
}