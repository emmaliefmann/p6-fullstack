import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Topic } from 'src/app/models/topic.model';
import { TopicList } from 'src/app/models/topicList.model';
import { TopicService } from 'src/app/services/topic.service';
import {MatCardModule} from '@angular/material/card';
import { NgFor } from '@angular/common';

@Component({
    selector: 'app-topics',
    templateUrl: './topics.component.html',
    styleUrls: ['./topics.component.scss'],
    imports: [MatCardModule, NgFor],
    standalone: true
})
export class TopicsComponent implements OnInit {

  constructor(private topicService: TopicService) {}

  public topics!: Topic[];
  public topics$: Observable<TopicList> = this.topicService.getAllTopics();
  
  ngOnInit(): void {
    this.topics$ = this.topicService.getAllTopics();
    
    this.topicService.getAllTopics().subscribe({
      next: (topicList) => {
        console.log(topicList.topics);
        this.topics = topicList.topics;
      }
    })
  }

}
