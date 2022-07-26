import React, { Component } from 'react';
import BookService from '../services/BookService';

class BooksListComponent extends Component {

    constructor(props){
        super(props)
        this.state = {
            books:[]
        }
    }

    componentDidMount(){
        BookService.getBooks().then((res)=>{
            this.setState({books: res.data});
        });
    }

    render() {
        return (
            <div>
                <h1 className='text-center'>Whole library</h1>
                <div className='row'>
                    <table className='table table-bordered'>
                        <thead>
                            <tr>
                                <th scope="col">Title</th>
                                <th scope="col">Author</th>
                                <th scope="col">Publication date</th>
                                <th scope="col">Publisher</th>
                                <th scope="col">ISBN</th>
                            </tr>
                        </thead>
                        <tbody>
                            {
                                this.state.books.map(
                                    book =>
                                    <tr key={book.id}>
                                        <td>{book.title}</td>
                                        <td>{book.author}</td>
                                        <td>{book.publishDate}</td>
                                        <td>{book.publisher}</td>
                                        <td>{book.isbn}</td>
                                    </tr>
                                )
                            }
                        </tbody>
                    </table>
                </div>
            </div>
        );
    }
}


export default BooksListComponent;