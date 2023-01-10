using System.Runtime.Serialization;

namespace Models {
    
    [DataContract]
    public class Range
    {
        public int range_highway;
        public int range_city;
        public int range_country;


        public Range(int range_highway, int range_city, int range_country) {
            this.range_highway = range_highway;
            this.range_city = range_city;
            this.range_country = range_country;
        }

        public override string ToString() {
            string str = "The configured range is " + this.range_highway + " on the highway" + Environment.NewLine 
                    + " and " + this.range_city + " in the city and " + this.range_country + " in the country.";
            return str;
        }
    }
}