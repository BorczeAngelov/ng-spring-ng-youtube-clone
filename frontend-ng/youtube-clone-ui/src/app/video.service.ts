import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { FileSystemFileEntry } from 'ngx-file-drop';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class VideoService {

  private url = "http://localhost:8080/api/videos/";

  constructor(private httpCLient: HttpClient) { }

  uploadVideo(file: File): Observable<any> {
    // http post call

    const formData = new FormData()
    formData.append('file', file, file.name);

    return this.httpCLient.post(this.url, formData);
  }
}
