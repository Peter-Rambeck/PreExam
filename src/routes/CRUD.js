import { useEffect, useState } from "react";
import CenteredContainer from "../components/CenteredContainer";
import { Button, Form } from "react-bootstrap";
import { fetchData, https } from "../apiUtils";

const initialValues = {
  title: "",
  authors: "",
  isbn: "",
  publisher: "",
  publishYear: "",
};

function Crud() {
  const [formData, setFormData] = useState(initialValues);

  function handleChange(e) {
    setFormData({
      ...formData,
      [e.target.name]: e.target.value,
    });
  }

  function handleSubmit(event) {
    event.preventDefault();
    console.log(formData);
    const body = { ...formData };
    try {
      fetchData(
        "https://peterrambeckandersen.com/tomcat/insession-starter/api/book/create",
        https.POST,
        body
      );
      console.log(body);
    } catch (e) {
      console.log("Not working");
    }
    // setFormData(initialValues);
  }

  return (
    <CenteredContainer>
      <Form onSubmit={handleSubmit}>
        <Form.Group controlId="bookData">
          <Form.Label>Book data</Form.Label>
          <Form.Control
            type="text"
            name="authors"
            value={formData.authors}
            onChange={handleChange}
            placeholder="Enter authors"
          />
          <Form.Control
            type="number"
            name="isbn"
            value={formData.isbn}
            onChange={handleChange}
            placeholder="Enter isbn"
          />
          <Form.Control
            type="text"
            name="publishYear"
            value={formData.publishYear}
            onChange={handleChange}
            placeholder="Enter year"
          />
          <Form.Control
            type="text"
            name="publisher"
            value={formData.publisher}
            onChange={handleChange}
            placeholder="Enter publisher"
          />
          <Form.Control
            type="text"
            name="title"
            value={formData.title}
            onChange={handleChange}
            placeholder="Enter booktitle"
          />
        </Form.Group>
        <Button block type="submit">
          Sign in
        </Button>
      </Form>
    </CenteredContainer>
  );
}

export default Crud;
