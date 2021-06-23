import axios from 'axios';
const Formations_base_URL = "http://localhost:8009/api/formations";
class FormationService{

    getFormation(){
        return axios.get(Formations_base_URL);
    }
    
}
export default new FormationService;