import React, { useEffect } from "react";
import { useState } from "react";
import { fetchData, https } from "../apiUtils";
import CenteredContainer from "../components/CenteredContainer";
import {
  Accordion,
  Card,
  Col,
  Container,
  Nav,
  Row,
  Form,
  Button,
} from "react-bootstrap";

const initialValues = {
  title: "",
  authors: "",
  isbn: "",
  publisher: "",
  publishYear: "",
};

function BooksPage() {
  const [library, setLibrary] = useState();
  const [search, setSearch] = useState("");
  const [formData, setFormData] = useState(initialValues);

  React.useEffect(() => {
    fetchData(
      "https://peterrambeckandersen.com/tomcat/insession-starter/api/book/all"
    )
      .then((data) => setLibrary(data))
      .catch((err) => console.log(err));
  }, []);
  console.log(search);
  console.log(library);

  function bookFiltering(item, search) {
    return item.title.toLowerCase().includes(search.toLowerCase());
  }
  console.log(bookFiltering);

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
        "https://peterrambeckandersen.com/tomcat/insession-starter/api/book/edit",
        https.POST,
        body
      );
      console.log(body);
    } catch (e) {
      console.log("Not working");
    }
  }

  const handleData = (item) => {
    setFormData(item);
  };

  return (
    // <Container style={{ alignItems: "center", justifyContent: "flex-end" }}>
    <Row>
      <Container>
        <Col sm={6}>
          <table className="table">
            <thead>
              <div>
                <tr>
                  <th>Autors</th>
                  <th>Id</th>
                  <th>isbn</th>
                  <th>Publish year</th>
                  <th>Publisher</th>
                  <th>Title</th>
                  <th>Update</th>
                  <th>Delete</th>
                </tr>
              </div>
            </thead>
            <tbody>
              {library && (
                <div>
                  {library.map((item) => (
                    <tr key={item.id} onClick={() => handleData(item)}>
                      <td>{item.authors}</td>
                      <td>{item.id}</td>
                      <td>{item.isbn}</td>
                      <td>{item.publishYear}</td>
                      <td>{item.publisher}</td>
                      <td>{item.title}</td>
                      <td>{item.title}</td>
                      <td>
                        <button>Edit</button>
                      </td>
                      <td>
                        <button>Delete</button>
                      </td>
                    </tr>
                  ))}
                </div>
              )}
            </tbody>
          </table>
        </Col>
      </Container>

      <Container>
        <Col sm={6}>
          <h1 className="text-center">Welcome to </h1>
          <hr />
          <div className="d-flex flex-wrap justify-content-center">
            <Form.Group controlId="formSeach">
              <Form.Control
                className="mt-2"
                type="search"
                size="lg"
                value={search}
                onChange={(e) => setSearch(e.target.value)}
                placeholder="Search for a book"
              />
            </Form.Group>
          </div>
          <hr className="mb-4" />
          {library && (
            <div
              className="d-flex flex-wrap justify-content-center"
              style={{ gap: "20px" }}
            >
              {library.map((item) => (
                <p>{item.title}</p>
              ))}
            </div>
          )}

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
              Edit
            </Button>
            <Button block type="submit2">
              Delete
            </Button>
          </Form>
        </Col>
      </Container>
    </Row>
    //</Container>
  );
}
export default BooksPage;
