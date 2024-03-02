import logo from './logo.svg';
import './App.css';
import LabSeqFetcher from './LabSeqFetcher';

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <LabSeqFetcher />
      </header>
    </div>
  );
}

export default App;
