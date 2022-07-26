import React, { Component } from 'react';

class HeaderComponent extends Component {
    render() {
        return (
            <div>
                <header className='header'>
                    <nav class="navbar navbar-expand-lg bg-pimary">
                        <div class="container-fluid">
                            <a class="navbar-brand" href="#">Library manager</a>
                            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
                            <span class="navbar-toggler-icon"></span>
                            </button>
                            <div class="collapse navbar-collapse" id="navbarText">
                            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                                <li class="nav-item">
                                <a class="nav-link active" aria-current="page" href="#">Home</a>
                                </li>
                                <li class="nav-item">
                                <a class="nav-link" href="#">Features</a>
                                </li>
                                <li class="nav-item">
                                <a class="nav-link" href="#">Pricing</a>
                                </li>
                            </ul>
                            </div>
                        </div>
                    </nav>
                </header>
            </div>
        );
    }
}

export default HeaderComponent;