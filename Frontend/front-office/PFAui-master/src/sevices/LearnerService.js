import axios from 'axios';

const LEARNER_API_BASE_URL = "http://localhost:8009/api/appprenat";

class LearnerService {

    createLearner(learner){
        return axios.post(LEARNER_API_BASE_URL, learner);
    }
    login(learner){
        return axios.post("http://localhost:8009/api/appprenat/login", learner);
    }    
}

export default new LearnerService()