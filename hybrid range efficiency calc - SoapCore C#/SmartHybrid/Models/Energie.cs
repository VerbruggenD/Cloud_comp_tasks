using System.Runtime.Serialization;

namespace Models {
    
    [DataContract]
    public class Energie
    {
        [DataMember]
        public float avg_consum_highway;
        [DataMember]
        public float avg_consum_city;
        [DataMember]
        public float avg_consum_country;
        [DataMember]
        public int capacity;


        public Energie(float avg_consum_highway, float avg_consum_city, float avg_consum_country, int capacity) {
            this.avg_consum_highway = avg_consum_highway;
            this.avg_consum_city = avg_consum_city;
            this.avg_consum_country = avg_consum_country;
            this.capacity = capacity;
        }

        public float calcEnergy(Range range) {
            float result = this.avg_consum_highway * range.range_highway + this.avg_consum_city * range.range_city + this.avg_consum_country * range.range_country;
            return result;
        }

        public override string ToString() {
            string highway = "On the highway: " + avg_consum_highway + " kW or l/100km";
            string city = "In the city: " + avg_consum_city + " kW or l/100km";
            string country = "In the country: " + avg_consum_country + " kW or l/100km";
            string capacityStr = "Capacity: " + capacity + " kWh or l";
            return highway + Environment.NewLine + city + Environment.NewLine + country + Environment.NewLine + capacityStr;
        }
    }
}