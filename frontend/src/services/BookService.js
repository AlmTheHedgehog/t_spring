import axios from 'axios';

const BOOK_BASE_API_URL = "http://localhost:8080/api/v1/books"

class BookService{
    getBooks(){
        return axios.get(BOOK_BASE_API_URL);
    }
}

export default new BookService()