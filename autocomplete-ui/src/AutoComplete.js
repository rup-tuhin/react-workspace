import React, {Component, Fragment} from "react";
import "./Autocomplete.css";


class Autocomplete extends Component {
    constructor(props) {
        super(props);
        this.state = {
            suggestions: [],
            activeSuggestions: 0,
            filteredSuggestions: [],
            showSuggestions: false,
            userInput: ""
        }
    };

    fetchSuggestions = () => {
        fetch("http://localhost:8080/suggestions")
            .then(res => res.json())
            .then(
                (items) => {
                    this.setState({
                        isLoaded: true,
                        suggestions: items,
                    });
                },
                (error) => {
                    this.setState({
                        isLoaded: true,
                        error
                    });
                }
            )
    }

    componentDidMount() {
        this.fetchSuggestions();
    }

    onChange = e => {
        const suggestions = [ ...this.state.suggestions];
        const userInput = e.currentTarget.value;

        const filteredSuggestions = suggestions.filter(
            suggestion =>
                suggestion.toLowerCase().indexOf(userInput.toLowerCase()) > -1
        );

        this.setState({
            activeSuggestion: 0,
            filteredSuggestions,
            showSuggestions: true,
            userInput: e.currentTarget.value
        });
    };

    onClick = e => {
        this.setState({
            activeSuggestion: 0,
            filteredSuggestions: [],
            showSuggestions: false,
            userInput: e.currentTarget.innerText
        });
    };

    onKeyDown = e => {
        const {activeSuggestion, filteredSuggestions} = this.state;

        // Enter
        if (13 === e.keyCode) {
            this.setState({
                activeSuggestion: 0,
                showSuggestions: false,
                userInput: filteredSuggestions[activeSuggestion]
            });
            // Up Arrow
        } else if (38 === e.keyCode) {
            if (0 === activeSuggestion) {
                return;
            }
            this.setState({activeSuggestion: activeSuggestion - 1});
        }
        // Down Arrow
        else if (40 === e.keyCode) {
            if (activeSuggestion - 1 === filteredSuggestions.length) {
                return;
            }
            this.setState({activeSuggestion: activeSuggestion + 1});
        }
    };

    render() {
        const {
            onChange,
            onClick,
            onKeyDown,
            state: {
                activeSuggestion,
                filteredSuggestions,
                showSuggestions,
                userInput
            }
        } = this;

        let suggestionsListComponent;

        if (showSuggestions && userInput) {
            if (filteredSuggestions.length) {
                suggestionsListComponent = (
                    <ul class="suggestions">
                        {filteredSuggestions.map((suggestion, index) => {
                            let className;

                            // Flag the active suggestion with a class
                            if (index === activeSuggestion) {
                                className = "suggestion-active";
                            }
                            return (
                                <li className={className} key={suggestion} onClick={onClick}>
                                    {suggestion}
                                </li>
                            );
                        })}
                    </ul>
                );
            } else {
                suggestionsListComponent = (
                    <div class="no-suggestions">
                        <em>No suggestions available.</em>
                    </div>
                );
            }
        }
        return (
            <Fragment>
                <input
                    type="text"
                    onChange={onChange}
                    onKeyDown={onKeyDown}
                    value={userInput}
                />
                {suggestionsListComponent}
            </Fragment>
        );
    }
}

export default Autocomplete;