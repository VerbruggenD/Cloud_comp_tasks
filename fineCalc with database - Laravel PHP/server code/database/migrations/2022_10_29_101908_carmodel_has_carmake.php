<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

return new class extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::table('carmodels', function (Blueprint $table) {
            $table->integer('make_id'); 
        });
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        if (Schema::hasColumn('carmodels', 'make_id')) {
            Schema::table('carmodels', function(Blueprint $table) {
                $table->dropColumn('make_ids');
            });
        }
    }
};
