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
                <h2 className='text-center'>Whole library</h2>
                <div className='row'>
                    <table className='table table-bordered'>
                        <thead>
                            <tr>
                                <th scope="col">Title</th>
                                <th scope="col">Author</th>
                                <th scope="col">Year</th>
                                <th scope="col">Publisher</th>
                                <th scope="col">ISBN</th>
                            </tr>
                        </thead>
                        <tbody>
                            {
                                this.state.books.map(
                                    book =>
                                    <tr key={book.id}>
                                        <th scope='row'>{book.title}</th>
                                        <th scope='row'>{book.author}</th>
                                        <th scope='row'>{book.publishDate}</th>
                                        <th scope='row'>{book.publisher}</th>
                                        <th scope='row'>{book.isbn}</th>
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