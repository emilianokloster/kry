import { useState } from "react";
import { useHistory } from "react-router-dom";
import Button from "./Button";
import DisabledButton from "./DisabledButton";

const AddEndpoint = () => {
  const [name, setName] = useState('');
  const [url, setUrl] = useState('');
  const [comment, setDescription] = useState('');
  const [isWorking, setIsWorking] = useState(false);

  const redirect = useHistory();

  const handleSubmit = (e) => {
    setIsWorking(true);
    e.preventDefault();
    const endpoint = {name, url, comment};

    fetch('http://localhost:8080/endpoints', {
      method: 'POST',
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(endpoint)
    }).then(() => {
      setIsWorking(false);
      redirect.push('/endpoints');
    })
  };

  return (
    <div className="add-endpoint">
      <h2>Add new endpoint</h2>

      <form onSubmit={handleSubmit}>

        <label>Name</label>
        <input 
          type="text" 
          required
          value={name}
          onChange={(e) => setName(e.target.value)}
        />

        <label>Url</label>
        <input 
          type="text" 
          required
          value={url}
          onChange={(e) => setUrl(e.target.value)}
        />

        <label>Description</label>
        <textarea 
          value={comment}
          onChange={(e) => setDescription(e.target.value)}
        />

        {!isWorking && <Button text="Save"/>}
        {isWorking && <DisabledButton text="Saving..."/>}
      </form> 

    </div>
  );
};

export default AddEndpoint;
