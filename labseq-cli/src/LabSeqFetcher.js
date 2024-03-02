import React, { useState } from 'react';
import axios from 'axios';

const LabSeqFetcher = () => {
  const [number, setNumber] = useState('');
  const [sequenceValue, setSequenceValue] = useState(null);
  const [loading, setLoading] = useState(false);

  const fetchSequenceValue = async () => {
    setLoading(true);
    try {
      const response = await axios.get(`http://localhost:8080/labseq/${number}`);
      setSequenceValue(response.data);
    } catch (error) {
      console.error('Error fetching sequence value:', error);
      alert('Error fetching sequence value.');
    } finally {
      setLoading(false);
    }
  };

  return (
    <div style={{ textAlign: 'center' }}> {}
      <input
        type="number"
        value={number}
        onChange={(e) => setNumber(e.target.value)}
        placeholder="Enter a number"
        style={{ display: 'block', margin: '0 auto' }} 
      />
      <button onClick={fetchSequenceValue} disabled={loading} style={{ display: 'block', margin: '10px auto' }}> {}
        Fetch Sequence Value
      </button>
      {sequenceValue !== null && <p>Sequence Value: {sequenceValue}</p>}
      <a
        href="http://localhost:8080/q/swagger-ui"
        target="_blank"
        rel="noopener noreferrer"
        style={{ display: 'block', margin: '10px auto' }} 
      >
        View API Documentation
      </a>
    </div>
  );
};

export default LabSeqFetcher;
