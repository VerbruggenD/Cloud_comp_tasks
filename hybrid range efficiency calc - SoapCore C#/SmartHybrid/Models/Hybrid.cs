using System.Runtime.Serialization;

namespace Models
{
    [DataContract]
    public class Hybrid
    {
        public float e_avg_consum_highway;
        public float e_avg_consum_city;
        public float e_avg_consum_country;
        public int e_capacity;

        public float p_avg_consum_highway;
        public float p_avg_consum_city;
        public float p_avg_consum_country;
        public int p_capacity;

        [DataMember]
        public Energie electric;
        [DataMember]
        public Energie petrol;

        public Hybrid(float e_avg_consum_highway, float e_avg_consum_city, float e_avg_consum_country, 
                float p_avg_consum_highway, float p_avg_consum_city, float p_avg_consum_country, 
                int e_capacity, int p_capacity) 
        {
            this.e_avg_consum_highway = e_avg_consum_highway;
            this.e_avg_consum_city = e_avg_consum_city;
            this.e_avg_consum_country = e_avg_consum_country;
            this.p_avg_consum_highway = p_avg_consum_highway;
            this.p_avg_consum_city = p_avg_consum_city;
            this.p_avg_consum_country = p_avg_consum_country;
            this.e_capacity = e_capacity;
            this.p_capacity = p_capacity;

            this.electric = new Energie(e_avg_consum_highway, e_avg_consum_city, e_avg_consum_country, e_capacity);
            this.petrol = new Energie(p_avg_consum_highway, p_avg_consum_city, p_avg_consum_country, p_capacity);
        }

        public Hybrid(Energie electric, Energie petrol) {
            this.electric = electric;
            this.petrol = petrol;
        }

        public override string ToString() {
            string e_string = electric.ToString();
            string p_string = petrol.ToString();
            return "electric: " + Environment.NewLine + e_string + Environment.NewLine + "petrol: " + Environment.NewLine + p_string;
        }
        
    }
}