/* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.activiti.engine.impl.asyncexecutor;

import java.util.Collection;

import org.activiti.engine.impl.interceptor.Command;
import org.activiti.engine.impl.interceptor.CommandContext;

/**
 * @author Joram Barrez
 */
public class ResetExpiredJobsCmd implements Command<Void> {
  
  protected Collection<String> jobIds;
  
  public ResetExpiredJobsCmd(Collection<String> jobsIds) {
    this.jobIds = jobsIds;
  }
  
  @Override
  public Void execute(CommandContext commandContext) {
    for (String jobId : jobIds) {
      commandContext.getJobEntityManager().resetExpiredJob(jobId);
    }
    return null;
  }

}
