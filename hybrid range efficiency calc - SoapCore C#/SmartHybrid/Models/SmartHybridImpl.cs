namespace Models
{
    public class SmartHybridImpl : ISmartHybridContract
    {
        public Hybrid makeHybrid(float e_avg_consum_highway, float e_avg_consum_city, float e_avg_consum_country, 
                float p_avg_consum_highway, float p_avg_consum_city, float p_avg_consum_country, 
                int e_capacity, int p_capacity)
        {
            Energie electric = new Energie(e_avg_consum_highway, e_avg_consum_city, e_avg_consum_country, e_capacity);
            Energie petrol = new Energie(p_avg_consum_highway, p_avg_consum_city, p_avg_consum_country, p_capacity);

            Hybrid hybrid = new Hybrid(electric, petrol);

            // Option 2 for constructing a hybrid:

            // Hybrid hybrid = new Hybrid(e_avg_consum_highway, e_avg_consum_city, e_avg_consum_country, 
            //         p_avg_consum_highway, p_avg_consum_city, p_avg_consum_country, 
            //         e_capacity, p_capacity);

            Console.WriteLine(hybrid.ToString());   // override of the build in ToString method -> in hybrid and energy

            return hybrid;  // when returning a string response this can be viewed in the wizdler
                            // wizdler does not support showing classes
        }

        public Energie calcEfficient(Hybrid hybrid, int rangeHighway, int rangeCity, int rangeCountry, float electricPrice, float petrolPrice) {

            Range range = new Range(rangeHighway, rangeCity, rangeCountry);

            float electricRange = hybrid.electric.calcEnergy(range);
            float petrolRange = hybrid.petrol.calcEnergy(range);

            if ((electricRange * electricPrice)>=(petrolRange * petrolPrice)) {
                Console.WriteLine(hybrid.electric.ToString());
                return hybrid.electric;
            }
            else {
                Console.WriteLine(hybrid.petrol.ToString());
                return hybrid.petrol;
            }
        }
    }
}